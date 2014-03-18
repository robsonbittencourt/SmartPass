package service;

import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;

import java.util.regex.Pattern;

import type.PasswordStrengthType;
import model.Password;

public class PasswordCheckCharacterTypes implements PasswordCheck {
	
	private double weigth = 20.0;

	public PasswordStrengthType checkPasswordStrength(Password password) {
		Pattern weakChecker = Pattern.compile("^(?=.*[A-Z].*)(?=.*[a-z].*)(?!.*[0-9].*)(?!.*[^A-Za-z0-9]).*$");
		Pattern mediumChecker = Pattern.compile("^(?=.*[A-Z].*)(?=.*[a-z].*)(?=.*[0-9].*)(?!.*[^A-Za-z0-9]).*$");
		Pattern strongChecker = Pattern.compile("^(?=.*[A-Z].*)(?=.*[a-z].*)(?=.*[0-9].*)(?=.*[^A-Za-z0-9]).*$");
		
		if (weakChecker.matcher(password.getPassword()).matches()) 
			return WEAK;
		if (mediumChecker.matcher(password.getPassword()).matches()) 
			return MEDIUM;
		if (strongChecker.matcher(password.getPassword()).matches()) 
			return STRONG;
		return WEAK;
	}

	public void setWeigth(double ponderation) {
		this.weigth = ponderation;
	}

	public double getWeigth() {
		return this.weigth;
	}

}
