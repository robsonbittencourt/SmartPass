package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity(name="users")
@SequenceGenerator(name = "users_id", sequenceName = "users_id")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "users_id")
	private long id;
	private String name;
	private String login;
	private String password;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
