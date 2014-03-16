package service;

import model.Password;
import static service.PasswordStrengthType.*;

public class PasswordCheckSize implements PasswordCheck{

	public PasswordStrengthType checkPassword(Password password) {
		int passwordLength = password.getPassword().length();
		
		if(passwordLength < 4)
			return WEAK;
		if(passwordLength < 8)
			return MEDIUM;
		
		return STRONG;
	}

}
