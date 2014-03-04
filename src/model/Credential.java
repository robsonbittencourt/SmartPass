package model;


public class Credential {
	
	private long id;
	private String system;
	private String user;
	private Password password;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getSystem() {
		return system;
	}
	
	public void setSystem(String system) {
		this.system = system;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public Password getPassword() {
		return password;
	}
	
	public void setPassword(Password password) {
		this.password = password;
	}

}
