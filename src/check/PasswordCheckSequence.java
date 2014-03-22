package check;

import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;
import model.Password;
import type.PasswordStrengthType;


public class PasswordCheckSequence extends PasswordCheck {

	public PasswordCheckSequence(double weight) {
		super(weight);
	}

	@Override
	public PasswordStrengthType checkPasswordStrength(Password password) {
		if(isSequence(password.getPassword(), 4))
			return WEAK;
		if(isSequence(password.getPassword(), 3))
			return MEDIUM;
		return STRONG;
	}
	
	public boolean isSequence(String password, int sequenceSize) {
		return isAscendentSequence(password, sequenceSize) ||
			   isDescendentSequence(password, sequenceSize) ||
			   isEqualsSequence(password, sequenceSize);
	}
	
	public boolean isAscendentSequence(String password, int sequenceSize) {
		return isSequence(password, sequenceSize, 1);
	}

	public boolean isDescendentSequence(String password, int sequenceSize) {
		return isSequence(password, sequenceSize, -1);
	}
	
	public boolean isEqualsSequence(String password, int sequenceSize) {
		return isSequence(password, sequenceSize, 0);
	}
	
	private boolean isSequence(String password, int sequenceSize, int modifier) {
		int count = 0;
		int lastUnicodeNumber = -1;
		
		for(char letter : password.toUpperCase().toCharArray()) {
			if (letter == lastUnicodeNumber + modifier)
				count++;
			else 
				count = 0;
			
			if (count == sequenceSize - 1) 
				return true;
			
			lastUnicodeNumber = letter;
		}
		
		return false;
	}
	
	@Override
	public String getCheck() {
		return "Sequence";
	}
	
}
