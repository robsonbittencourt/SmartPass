package check;

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
		Pattern weakPattern = Pattern.compile("^(?=.*[A-Z].*)(?=.*[a-z].*)(?!.*[0-9].*)(?!.*[^A-Za-z0-9]).*$");
		Pattern mediumPattern = Pattern.compile("^(?=.*[A-Z].*)(?=.*[a-z].*)(?=.*[0-9].*)(?!.*[^A-Za-z0-9]).*$");
		Pattern strongPattern = Pattern.compile("^(?=.*[A-Z].*)(?=.*[a-z].*)(?=.*[0-9].*)(?=.*[^A-Za-z0-9]).*$");
		
		if (strongPattern.matcher(password.getPassword()).matches()) 
			return STRONG;
		if (mediumPattern.matcher(password.getPassword()).matches()) 
			return MEDIUM;
		if (weakPattern.matcher(password.getPassword()).matches()) 
			return WEAK;
		return WEAK;
	}

	@Override
	public String getCheck() {
		return "CharacterTypes";
	}
	
}
