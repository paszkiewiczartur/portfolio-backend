package pl.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.Guest;
import pl.portfolio.entities.IpAddress;

@RepositoryRestResource(path = "ipAddresses", collectionResourceRel = "ipAddresses")
public interface IpAddressRepository extends JpaRepository<IpAddress, Long> {
	IpAddress findByIp(String ip);
	List<IpAddress> findByIdAndGuest(Long id, Guest guest);
	IpAddress findByGuestAndIp(Guest guest, String ip);
}