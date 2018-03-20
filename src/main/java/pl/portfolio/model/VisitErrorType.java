package pl.portfolio.model;

public enum VisitErrorType {
	MISSING_GUEST("missing guest"), 
	MISSING_IP_ID("missing ip.id"), 
	MISSING_IP("missing ip"), 
	GUEST_NOT_FOUND("guest not found in database"),
	IP_NOT_FOUND("ip.id not found in database");
	
	private String description;
	
	private VisitErrorType(String description){
		this.description = description;
	}
	
	@Override
	public String toString(){
		return description;
	}
	
}
