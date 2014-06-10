package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity(name="rsa_keys")
@SequenceGenerator(name = "rsa_keys_id", sequenceName = "rsa_keys_id")
public class RSAKeys {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "rsa_keys_id")
	@Column(name = "rsa_keys_id")
	private long id;
	
	@Column(name = "rsa_keys_first")
	private String first;
	
	@Column(name = "rsa_keys_last_public")
	private String lastPublic;
	
	@Column(name = "rsa_keys_last_private")
	private String lastPrivate;

	
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

	
	public String getLastPublic() {
		return lastPublic;
	}

	
	public void setLastPublic(String lastPublic) {
		this.lastPublic = lastPublic;
	}

	
	public String getLastPrivate() {
		return lastPrivate;
	}

	
	public void setLastPrivate(String lastPrivate) {
		this.lastPrivate = lastPrivate;
	}
	
}
