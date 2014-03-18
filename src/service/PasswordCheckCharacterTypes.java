package service;

import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;

import java.util.regex.Pattern;

import model.Password;
import type.PasswordStrengthType;

public class PasswordCheckCharacterTypes extends PasswordCheck {
	
	public PasswordCheckCharacterTypes(double weight) {
		super(weight);
	}

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
	
}
