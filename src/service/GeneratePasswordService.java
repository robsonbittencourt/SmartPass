package service;

import static type.PasswordStrengthType.STRONG;
import helper.RandomHelper;

import java.util.ArrayList;
import java.util.List;

import model.Password;
import type.PasswordStrengthType;
import br.com.caelum.vraptor.ioc.Component;
import check.PasswordCheck;
import check.PasswordCheckCharacterTypes;
import check.PasswordCheckDate;
import check.PasswordCheckDictionary;
import check.PasswordCheckSequence;
import check.PasswordCheckSize;

import com.google.inject.Inject;

@Component
public class GeneratePasswordService {
	
	@Inject
	private PasswordStrengthService passwordStrengthService;
	@Inject
	private RandomHelper randomString;
	
	public String generateRandomStrongPassword(int length) {
		if(length > 9) {
			boolean foundStrongPassword = true;
			Password password = new Password();
			
			while (foundStrongPassword) {
				password.setPassword(randomString.generateRandomString(length));
				
				PasswordStrengthType passwordStreght = passwordStrengthService.verifyPasswordStrenght(password, getAllPasswordCheckers());
				foundStrongPassword = !passwordStreght.equals(STRONG);
			}
			return password.getPassword();
		}
		return "";
	}
	
	private List<PasswordCheck> getAllPasswordCheckers() {
		List<PasswordCheck> checkers = new ArrayList<PasswordCheck>();
		checkers.add(new PasswordCheckCharacterTypes(30));
		checkers.add(new PasswordCheckSize(30));
		checkers.add(new PasswordCheckDictionary(20));
		checkers.add(new PasswordCheckDate(10));
		checkers.add(new PasswordCheckSequence(10));
		return checkers;
	}
}

