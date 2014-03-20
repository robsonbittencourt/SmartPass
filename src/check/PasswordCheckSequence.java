package check;

import static type.PasswordStrengthType.WEAK;

import java.util.regex.Pattern;

import model.Password;
import type.PasswordStrengthType;


public class PasswordCheckSequence extends PasswordCheck {

	public PasswordCheckSequence(double weight) {
		super(weight);
	}

	@Override
	public PasswordStrengthType checkPasswordStrength(Password password) {
		Pattern weakChecker = Pattern.compile("^(?!.*(0123|1234|2345|3456|4567|5678|6789|3210|4321|5432|6543|7654|8765|9876|0000|1111|2222|3333|4444|5555|6666|7777|8888|9999))"
											+ "(?!.*(abcd||cde|)).*$");
		
		
		return WEAK;
	}
	
}
