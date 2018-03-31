package pl.portfolio.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pl.portfolio.entities.Entrance;
import pl.portfolio.entities.Guest;
import pl.portfolio.entities.IpAddress;
import pl.portfolio.entities.VisitError;
import pl.portfolio.model.IpAddressDTO;
import pl.portfolio.model.VisitData;
import pl.portfolio.model.VisitErrorType;
import pl.portfolio.repository.EntrancesRepository;
import pl.portfolio.repository.GuestsRepository;
import pl.portfolio.repository.IpAddressRepository;
import pl.portfolio.repository.VisitErrorsRepository;

@Service
@Slf4j
public class VisitService {
	private final Long ADMIN_IP_ADDRESS = Integer.toUnsignedLong(2);
	private final Long VISIT_ERROR_GUEST_ID = Integer.toUnsignedLong(1);
	private final Long VISIT_ERROR_IP_ADDRESS_ID = Integer.toUnsignedLong(1);	
	
	@Autowired
	private GuestsRepository guestsRepo;
	@Autowired
	private IpAddressRepository ipAddressRepo;
	@Autowired
	private EntrancesRepository entrancesRepo;
	@Autowired
	private VisitErrorsRepository visitErrorsRepo;

	public VisitData saveGuest(IpAddressDTO ipAddressDTO){
		if(isAdmin(ipAddressDTO))
			return saveDataAdmin(ipAddressDTO);
		if(isStorageEmpty(ipAddressDTO)){
			return saveDataStorageEmpty(ipAddressDTO);
		} else {
			return saveDataStoragePresent(ipAddressDTO);
		}
	}

	private boolean isAdmin(IpAddressDTO ipAddressDTO){
		IpAddress ipAddress = ipAddressRepo.findOne(ADMIN_IP_ADDRESS);
		return ipAddress.getIp().equals(ipAddressDTO.getIp()) ? true : false; 
	}
		
	private VisitData saveDataAdmin(IpAddressDTO ipAddressDTO){
		IpAddress ipAddress = ipAddressRepo.findOne(ADMIN_IP_ADDRESS);
		return new VisitData(ipAddress.getId(), ipAddress.getGuest().getId(), saveEntrance(ipAddressDTO, ipAddress));
	}
	
	private boolean isStorageEmpty(IpAddressDTO ipAddressDTO){
		return ipAddressDTO.getGuest_id() == null && ipAddressDTO.getId() == null;
	}
	
	private VisitData saveDataStorageEmpty(IpAddressDTO ipAddressDTO){
		IpAddress ipAddress = ipAddressRepo.findByIp(ipAddressDTO.getIp());
		if(ipAddress != null){
			return saveDataStorageEmptyAndIpInDB(ipAddressDTO, ipAddress);
		} else {
			return saveDataStorageEmptyAndNewGuest(ipAddressDTO, ipAddress);
		}
	}
	
	private VisitData saveDataStorageEmptyAndIpInDB(IpAddressDTO ipAddressDTO, IpAddress ipAddress){
		log.info("Cleaned storage, ip in database");
		return new VisitData(ipAddress.getId(), ipAddress.getGuest().getId(), saveEntrance(ipAddressDTO, ipAddress));
	}
	
	private VisitData saveDataStorageEmptyAndNewGuest(IpAddressDTO ipAddressDTO, IpAddress ipAddress){
		log.info("New guest, no ip in database");
		ModelMapper modelMapper = new ModelMapper();
		Guest guest = new Guest();
		guest = guestsRepo.saveAndFlush(guest);
		ipAddress = modelMapper.map(ipAddressDTO, IpAddress.class);
		ipAddress.setGuest(guest);
		ipAddress = ipAddressRepo.saveAndFlush(ipAddress);
		return new VisitData(ipAddress.getId(), guest.getId(), saveEntrance(ipAddressDTO, ipAddress));
	}
	
	private Long saveEntrance(IpAddressDTO ipAddressDTO, IpAddress ipAddress){
		Entrance entrance = new Entrance();
		entrance.setIp_address(ipAddress);
		entrance.setBrowser(ipAddressDTO.getBrowser());
		entrance.setBrowserVersion(ipAddressDTO.getBrowserVersion());
		entrance = entrancesRepo.saveAndFlush(entrance);
		return entrance.getId();
	}

	private VisitData saveDataStoragePresent(IpAddressDTO ipAddressDTO){
		VisitError visitError = new VisitError();
		if(isDataValid(ipAddressDTO, visitError)){
			boolean error = false;
			Guest guest = null;
			if((guest  = guestsRepo.findOne(ipAddressDTO.getGuest_id())) == null){
				visitError = saveDataGuestNotFound(ipAddressDTO);
				error = true;
			}
			List<IpAddress> ipAddresses = new ArrayList<>();
			if(!error && (ipAddresses = ipAddressRepo.findByIdAndGuest(ipAddressDTO.getId(), guest)).size() == 0){
				visitError = saveDataIpNotFound(ipAddressDTO);
				error = true;
			}
			if(!error && !ipAddresses.get(0).getIp().equals(ipAddressDTO.getIp())){
				return saveDataOldUserDifferentIp(ipAddressDTO, guest);
			} else if(!error){
				return saveDataOldUserSameIp(ipAddressDTO, ipAddresses.get(0));
			} else {
				return saveDataInvalidOrError(ipAddressDTO, visitError);				
			}
		} else {
			return saveDataInvalidOrError(ipAddressDTO, visitError);
		}
	}

	
	private boolean isDataValid(IpAddressDTO ipAddressDTO, VisitError visitError){
		if(ipAddressDTO.getGuest_id() != null && ipAddressDTO.getId() == null){
			visitError = saveDataMissingIpId(ipAddressDTO);
			return false;
		}
		if(ipAddressDTO.getId() != null && ipAddressDTO.getGuest_id() == null){
			visitError = saveDataMissingGuest(ipAddressDTO);
			return false;
		}
		if(ipAddressDTO.getIp() == null){
			visitError = saveDataMissingIp(ipAddressDTO);
			return false;
		}
		return true;
	}
	
	private VisitError saveDataMissingIpId(IpAddressDTO ipAddressDTO){
		log.info("Error | " + VisitErrorType.MISSING_IP_ID);
		VisitError visitError = new VisitError();
		visitError.setVisitErrorType(VisitErrorType.MISSING_IP_ID);
		visitError.setGuest(ipAddressDTO.getGuest_id());
		if(ipAddressDTO.getIp() != null){
			visitError.setIp(ipAddressDTO.getIp());
		}		
		return visitError;
	}
	
	private VisitError saveDataMissingGuest(IpAddressDTO ipAddressDTO){
		log.info("Error | " + VisitErrorType.MISSING_GUEST);
		VisitError visitError = new VisitError();
		visitError.setVisitErrorType(VisitErrorType.MISSING_GUEST);
		visitError.setIpAddress(ipAddressDTO.getId());
		if(ipAddressDTO.getIp() != null){
			visitError.setIp(ipAddressDTO.getIp());
		}
		return visitError;
	}
	
	private VisitError saveDataMissingIp(IpAddressDTO ipAddressDTO){
		log.info("Error | " + VisitErrorType.MISSING_IP);
		VisitError visitError = new VisitError();
		visitError.setVisitErrorType(VisitErrorType.MISSING_IP);
		visitError.setGuest(ipAddressDTO.getGuest_id());
		visitError.setIpAddress(ipAddressDTO.getId());
		return visitError;
	}

	private VisitError saveDataGuestNotFound(IpAddressDTO ipAddressDTO){
		log.info("Error | " + VisitErrorType.GUEST_NOT_FOUND);
		VisitError visitError = new VisitError();
		visitError.setVisitErrorType(VisitErrorType.GUEST_NOT_FOUND);
		visitError.setGuest(ipAddressDTO.getGuest_id());
		visitError.setIpAddress(ipAddressDTO.getId());
		visitError.setIp(ipAddressDTO.getIp());
		return visitError;
	}				
	
	private VisitError saveDataIpNotFound(IpAddressDTO ipAddressDTO){
		log.info("Error | " + VisitErrorType.IP_NOT_FOUND);
		VisitError visitError = new VisitError();
		visitError.setVisitErrorType(VisitErrorType.IP_NOT_FOUND);
		visitError.setGuest(ipAddressDTO.getGuest_id());
		visitError.setIpAddress(ipAddressDTO.getId());
		visitError.setIp(ipAddressDTO.getIp());
		return visitError;
	}				

	private VisitData saveDataOldUserDifferentIp(IpAddressDTO ipAddressDTO, Guest guest){
		IpAddress ipAddress = ipAddressRepo.findByGuestAndIp(guest, ipAddressDTO.getIp());
		if(ipAddress != null){
			return saveDataOldUserDifferentIpButInDB(ipAddressDTO, ipAddress);
		} else {
			return saveDataOldUserNewIp(ipAddressDTO, guest);
		}
	}

	private VisitData saveDataOldUserDifferentIpButInDB(IpAddressDTO ipAddressDTO, IpAddress ipAddress){
		log.info("Old user and his current ip is present in database but different from the last visit");
		return new VisitData(ipAddress.getId(), ipAddress.getGuest().getId(), saveEntrance(ipAddressDTO, ipAddress));
	}	

	private VisitData saveDataOldUserNewIp(IpAddressDTO ipAddressDTO, Guest guest){
		log.info("Old user, new ip");
		ModelMapper modelMapper = new ModelMapper();
		IpAddress ipAddress = modelMapper.map(ipAddressDTO, IpAddress.class);
		ipAddress.setId(null);
		ipAddress.setGuest(guest);
		ipAddress = ipAddressRepo.saveAndFlush(ipAddress);
		return new VisitData(ipAddress.getId(), ipAddress.getGuest().getId(), saveEntrance(ipAddressDTO, ipAddress));
	}	
	
	private VisitData saveDataOldUserSameIp(IpAddressDTO ipAddressDTO, IpAddress ipAddress){
		log.info("Old user, last visit ip == current visit ip");
		return new VisitData(ipAddressDTO.getId(), ipAddressDTO.getGuest_id(), saveEntrance(ipAddressDTO, ipAddress));
	}

	private VisitData saveDataInvalidOrError(IpAddressDTO ipAddressDTO, VisitError visitError){
		visitErrorsRepo.saveAndFlush(visitError);
		IpAddress ipAddress = ipAddressRepo.findOne(VISIT_ERROR_IP_ADDRESS_ID);
		return new VisitData(ipAddress.getId(), VISIT_ERROR_GUEST_ID, saveEntrance(ipAddressDTO, ipAddress));
	}
}
