package check;

import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;
import type.PasswordStrengthType;
import model.Password;

public class PasswordCheckSize extends PasswordCheck {

	public PasswordCheckSize(double weight) {
		super(weight);
	}

	public PasswordStrengthType checkPasswordStrength(Password password) {
		int passwordLength = password.getPassword().length();
		
		if(passwordLength < 4)
			return WEAK;
		if(passwordLength < 9)
			return MEDIUM;
		
		return STRONG;
	}

}
