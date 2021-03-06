package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import encryption.RSAKey;

@Entity(name="public_key")
@SequenceGenerator(name = "public_key_id", sequenceName = "public_key_id")
public class PublicKey implements RSAKey{
	
	public PublicKey() {
		
	}
	
	public PublicKey(String key) {
		setFirst(key.substring(0, key.indexOf(",")));
		setLast(key.substring(key.indexOf(",") + 1));
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "public_key_id")
	@Column(name = "public_key_id")
	private long id;
	
	@Column(name = "public_key_first")
	private String first;
	
	@Column(name = "public_key_last")
	private String last;
	
	@Column(name = "public_key_user")
	private String user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
