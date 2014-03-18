package service;

import static service.PasswordStrengthType.MEDIUM;
import static service.PasswordStrengthType.STRONG;
import static service.PasswordStrengthType.WEAK;

import java.util.List;

import model.Password;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PasswordStrengthService {

	public PasswordStrengthType verifyPasswordStrenght(Password password, List<PasswordCheck> checkers) {
		applyWeight(password, checkers);
		return getPasswordStrength(password);
	}

	protected void applyWeight(Password password, List<PasswordCheck> checkers) {
		for (PasswordCheck checker : checkers) {
			applyWeightByChecker(password, checker);
		}
	}

	private void applyWeightByChecker(Password password, PasswordCheck checker) {
		PasswordStrengthType passwordStrength = checker.checkPasswordStrength(password);
		double ponderation = checker.getWeigth();
		
		if (passwordStrength.equals(WEAK))
			password.setWeakWeight(password.getWeakWeight() + ponderation);
		else if (passwordStrength.equals(MEDIUM))
			password.setMediumWeight(password.getMediumWeight() + ponderation);
		else if (passwordStrength.equals(STRONG))
			password.setStrongWeigth(password.getStrongWeigth() + ponderation);
	}
	
	private PasswordStrengthType getPasswordStrength(Password password) {
		if (isWeakPassword(password))
			return WEAK;
		if (isMediumPassword(password))
			return MEDIUM;
		if (isStrongPassword(password))
			return STRONG;
		return WEAK;
	}

	protected boolean isWeakPassword(Password password) {
		return (password.getWeakWeight() >= password.getMediumWeight() && password.getWeakWeight() >= password.getStrongWeigth());
	}

	protected boolean isMediumPassword(Password password) {
		return (password.getMediumWeight() > password.getWeakWeight() && password.getMediumWeight() >= password.getStrongWeigth());
	}

	protected boolean isStrongPassword(Password password) {
		return (password.getStrongWeigth() > password.getWeakWeight() && password.getStrongWeigth() > password.getMediumWeight());
	}

}
