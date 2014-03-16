package service;

import static service.PasswordStrengthType.MEDIUM;
import static service.PasswordStrengthType.STRONG;
import static service.PasswordStrengthType.WEAK;
import model.Password;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PasswordStrengthService {

	public PasswordStrengthType verifyPasswordStrenght(Password password) {
		applyPercentualStrong(password);
		if (isWeakPassword(password)) return WEAK;
		if (isMediumPassword(password)) return MEDIUM;
		if (isStrongPassword(password)) return STRONG;
		return null;
	}

	public void applyPercentualStrong(Password password) {
		applyPercentualStrongByChecker(password, new PasswordCheckSize(), 30.0);
		applyPercentualStrongByChecker(password, new PasswordCheckDictionary(), 20.0);
	}

	private void applyPercentualStrongByChecker(Password password, PasswordCheck checker, double percentual) {
		if (checker.checkPassword(password).equals(WEAK)) password.setPercentualWeak(password.getPercentualWeak() + percentual);
		else if (checker.checkPassword(password).equals(MEDIUM)) password.setPercentualMedium(password.getPercentualMedium() + percentual);
		else if (checker.checkPassword(password).equals(STRONG)) password.setPercentualStrong(password.getPercentualStrong() + percentual);
	}
	
	public boolean isWeakPassword(Password password) {
		return (password.getPercentualWeak() >= password.getPercentualMedium() && password.getPercentualWeak() >= password.getPercentualStrong());
	}

	public boolean isMediumPassword(Password password) {
		return (password.getPercentualMedium() > password.getPercentualWeak() && password.getPercentualMedium() >= password.getPercentualStrong());
	}

	public boolean isStrongPassword(Password password) {
		return (password.getPercentualStrong() > password.getPercentualWeak() && password.getPercentualStrong() > password.getPercentualMedium());
	}

}
