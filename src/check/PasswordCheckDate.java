package check;

import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;

import java.util.regex.Pattern;

import model.Password;
import type.PasswordStrengthType;

public class PasswordCheckDate extends PasswordCheck {

	public PasswordCheckDate(double weight) {
		super(weight);
	}

	@Override
	public PasswordStrengthType checkPasswordStrength(Password password) {
		Pattern weakPattern = Pattern.compile("(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])((19|20)\\d{2})");
		Pattern mediumPattern = Pattern.compile("(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])(\\d{2})");
		
		if(weakPattern.matcher(password.getPassword()).matches())		
			return WEAK;
		if(mediumPattern.matcher(password.getPassword()).matches())
			return MEDIUM;
		return STRONG;
	}
	
}
