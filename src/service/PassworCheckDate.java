package service;

import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.*;

import java.util.regex.Pattern;

import model.Password;
import type.PasswordStrengthType;


public class PassworCheckDate extends PasswordCheck {

	public PassworCheckDate(double weight) {
		super(weight);
	}

	@Override
	public PasswordStrengthType checkPasswordStrength(Password password) {
		Pattern weakChecker = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])(0?[1-9]|1[012])((19|20)\\d\\d)");
		Pattern mediumChecker = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])(0?[1-9]|1[012])(\\d\\d)");
		
		if(weakChecker.matcher(password.getPassword()).matches())		
			return WEAK;
		if(mediumChecker.matcher(password.getPassword()).matches())
			return MEDIUM;
		return STRONG;
	}
	
	
	
	

}
