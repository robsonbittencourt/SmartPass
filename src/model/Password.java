package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity(name="password")
@SequenceGenerator(name = "password_id", sequenceName = "password_id")
public class Password {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "password_id")
	@Column(name = "password_id")
	private long id;
	
	@Transient
	private String password;
	
	@Transient
	private double weakWeight;
	
	@Transient
	private double mediumWeight;
	
	@Transient
	private double strongWeight;
	
	@Column(name = "password_encryption_key")
	private String encryptionKey;
	
	@Column(name = "password_iv")
	private String IV;
	
	@Column(name = "password_cipher_text")
	private byte[] cipherText;
	
	public Password() {
		this.weakWeight = 0;
		this.mediumWeight = 0;
		this.strongWeight = 0;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getWeakWeight() {
		return weakWeight;
	}

	public void setWeakWeight(double weakWeight) {
		this.weakWeight = weakWeight;
	}

	public double getMediumWeight() {
		return mediumWeight;
	}

	public void setMediumWeight(double mediumWeight) {
		this.mediumWeight = mediumWeight;
	}

	public double getStrongWeight() {
		return strongWeight;
	}
	
	public void setStrongWeigth(double strongWeight) {
		this.strongWeight = strongWeight;
	}
	
	public String getEncryptionKey() {
		return encryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	public String getIV() {
		return IV;
	}

	public void setIV(String iV) {
		IV = iV;
	}

	public byte[] getCipherText() {
		return cipherText;
	}

	public void setCipherText(byte[] cipherText) {
		this.cipherText = cipherText;
	}

	
}
