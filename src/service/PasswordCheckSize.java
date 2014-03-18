package service;

import model.Password;
import static service.PasswordStrengthType.*;

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

	public void setPonderation(double ponderation) {
		this.ponderation = ponderation;
	}
	
	public double getPonderation() {
		return ponderation;
	}

}
