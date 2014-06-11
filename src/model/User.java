package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="users")
@SequenceGenerator(name = "users_id", sequenceName = "users_id")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "users_id")
	@Column(name = "users_id")
	private long id;
	
	@Column(name = "users_login")
	private String login;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "users_password")
	private Password password;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "credential_users")
	private List<Credential> credentials;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "users_public_key")
	private PublicKey publicKey;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "users_private_key")
	private PrivateKey privateKey;
		
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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

	public List<Credential> getCredentials() {
		return credentials;
	}

	public void setCredentials(List<Credential> credentials) {
		this.credentials = credentials;
	}
	
	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}
	
}
