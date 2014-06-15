package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import encryption.RsaKey;

@Entity(name="private_key")
@SequenceGenerator(name = "private_key_id", sequenceName = "private_key_id")
public class PrivateKey implements RsaKey{
	
	public PrivateKey() {

	}	
	
	public PrivateKey(String key) {
		setFirst(key.substring(0, key.indexOf(",")));
		setLast(key.substring(key.indexOf(",") + 1));
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "private_key_id")
	@Column(name = "private_key_id")
	private long id;
	
	@Column(name = "private_key_first")
	private String first;
	
	@Column(name = "private_key_last")
	private String last;
	
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

}
