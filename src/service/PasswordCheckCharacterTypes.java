package service;

import java.util.regex.Pattern;

import model.Password;

public class PasswordCheckCharacterTypes implements PasswordCheck {
	
	private double ponderation = 20.0;

	public PasswordStrengthType checkPasswordStrength(Password password) {
		Pattern weakChecker = Pattern.compile("^(?=.*[A-Z].*)(?=.*[a-z].*)(?!.*[0-9].*)(?!.*[^A-Za-z0-9]).*$");
		Pattern mediumChecker = Pattern.compile("^(?=.*[A-Z].*)(?=.*[a-z].*)(?=.*[0-9].*)(?!.*[^A-Za-z0-9]).*$");
		Pattern strongChecker = Pattern.compile("^(?=.*[A-Z].*)(?=.*[a-z].*)(?=.*[0-9].*)(?=.*[^A-Za-z0-9]).*$");
		
		if (weakChecker.matcher(password.getPassword()).matches()) 
			return PasswordStrengthType.WEAK;
		if (mediumChecker.matcher(password.getPassword()).matches()) 
			return PasswordStrengthType.MEDIUM;
		if (strongChecker.matcher(password.getPassword()).matches()) 
			return PasswordStrengthType.STRONG;
		return PasswordStrengthType.WEAK;
	}

	public void setPonderation(double ponderation) {
		this.ponderation = ponderation;
	}

	public double getPonderation() {
		return this.ponderation;
	}

}
