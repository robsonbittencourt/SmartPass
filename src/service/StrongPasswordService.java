package service;

import static type.PasswordStreghtType.MEDIUM;
import static type.PasswordStreghtType.STRONG;
import static type.PasswordStreghtType.WEAK;
import type.PasswordStreghtType;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class StrongPasswordService {
	
	public PasswordStreghtType verifyPasswordStrenght(String password) {
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
