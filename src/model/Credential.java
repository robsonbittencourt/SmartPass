package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="credential")
@SequenceGenerator(name = "credential_id", sequenceName = "credential_id")
public class Credential {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "credential_id")
	@Column(name = "credential_id")
	private long id;
	
	@Column(name = "credential_system")
	private String system;
	
	@Column(name = "credential_login")
	private String login;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "credential_password")
	private Password password;
	
	@ManyToOne
	@JoinColumn(name = "credential_users")
	private User user;
	
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
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public Password getPassword() {
		return password;
	}
	
	public void setPassword(Password password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
