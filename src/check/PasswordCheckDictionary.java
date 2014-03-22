package check;

import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;

import java.util.ArrayList;

import model.Password;
import type.PasswordStrengthType;

public class PasswordCheckDictionary extends PasswordCheck {

	public PasswordCheckDictionary(double weight) {
		super(weight);
	}

	public PasswordStrengthType checkPasswordStrength(Password password) {
		// TODO: It's a fake implementation
		ArrayList<String> dictionary = new ArrayList<String>();
		dictionary.add("casa");
		dictionary.add("pão");
		
		if (dictionary.contains(password.getPassword()))
			return WEAK;
		else 
			return STRONG;
	}

	@Override
	public String getCheck() {
		return "Dictionary";
	}
	
}
