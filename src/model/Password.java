package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="password")
@SequenceGenerator(name = "password_id", sequenceName = "password_id")
public class Password {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "password_id")
	@Column(name = "password_id")
	private long id;
	
	@Column(name = "password_password")
	private String password;
	
	@Column(name = "password_status")
	private String status;
	
	@Column(name = "password_weak_weight")
	private double weakWeight;
	
	@Column(name = "password_medium_weight")
	private double mediumWeight;
	
	@Column(name = "password_strong_weight")
	private double strongWeight;
	
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

	public String getStatus() {
		return status;
	}

	public void setMessageStatus(String status) {
		this.status = status;
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
	
}
