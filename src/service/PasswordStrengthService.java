package service;

import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;
import type.PasswordStrengthType;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PasswordStrengthService {
	
	public PasswordStrengthType verifyPasswordStrenght(String password) {
		if (isStrongPassword(password))
			return STRONG;
		if(isMediumPassword(password))
			return MEDIUM;
		if(isWeakPassword(password))
			return WEAK;
		return null;
	}
	
	private boolean isStrongPassword(String password) {
		return false;
	}
	
	private boolean isMediumPassword(String password) {
		return false;
	}
	
	private boolean isWeakPassword(String password) {
		return true;
	}
}
