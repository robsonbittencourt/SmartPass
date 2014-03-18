package service;

import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;
import type.PasswordStrengthType;
import model.Password;

public class PasswordCheckSize implements PasswordCheck{

	private double ponderation = 30.0;

	public PasswordStrengthType checkPasswordStrength(Password password) {
		int passwordLength = password.getPassword().length();
		
		if(passwordLength < 4)
			return WEAK;
		if(passwordLength < 8)
			return MEDIUM;
		
		return STRONG;
	}

	public void setWeigth(double ponderation) {
		this.ponderation = ponderation;
	}
	
	public double getWeigth() {
		return ponderation;
	}

}
