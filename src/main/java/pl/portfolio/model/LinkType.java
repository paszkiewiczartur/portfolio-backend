package pl.portfolio.model;

public enum LinkType {
	VISIT("main visit"),//0
	WEBSITE("website"),//1
	DOWNLOAD("download"),//2
	GITHUB("github");//3
	
	private String description;
	
	private LinkType(String description){
		this.description = description;
	}
	
	@Override
	public String toString(){
		return description;
	}
	
}
