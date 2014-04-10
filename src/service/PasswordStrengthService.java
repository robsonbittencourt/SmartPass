package service;

import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;

import java.util.List;

import check.PasswordCheck;
import type.PasswordStrengthType;
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
			password.setStrongWeigth(password.getStrongWeight() + ponderation);
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
		return (password.getWeakWeight() >= password.getMediumWeight() && password.getWeakWeight() >= password.getStrongWeight());
	}

	protected boolean isMediumPassword(Password password) {
		return (password.getMediumWeight() > password.getWeakWeight() && password.getMediumWeight() >= password.getStrongWeight());
	}

	protected boolean isStrongPassword(Password password) {
		return (password.getStrongWeight() > password.getWeakWeight() && password.getStrongWeight() > password.getMediumWeight());
	}

}
