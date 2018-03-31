package pl.portfolio.model;

public enum Site {
	About("about me"),//0
	Contact("contact"),//1
	Project("project"),//2
	Course("course"),//3
	Book("book"),//4
	Tag("tag"),//5
	Home("home"),//6
	Signin("signin");//7
	
	private String description;
	
	private Site(String description){
		this.description = description;
	}
	
	@Override
	public String toString(){
		return description;
	}
	
}
