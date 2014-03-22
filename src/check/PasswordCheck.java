package check;

import model.Password;
import type.PasswordStrengthType;

public abstract class PasswordCheck {
	private double weight;
	
	public abstract PasswordStrengthType checkPasswordStrength(Password password);
	
	public PasswordCheck(double weight) {
		this.weight = weight;
	}
	
	public void setWeigth(double weight) {
		this.weight = weight;
	}
	
	public double getWeigth() {
		return weight;
	}

	public abstract String getCheck();
	
}
