package service;

import static type.PasswordStrengthType.STRONG;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	public String generateRandomStrongPassword(int length) {
		if(length > 9) {
			boolean foundStrongPassword = true;
			Password password = new Password();
			
			while (foundStrongPassword) {
				password.setPassword(generateRandomString(length));
				
				PasswordStrengthType passwordStreght = passwordStrengthService.verifyPasswordStrenght(password, getAllPasswordCheckers());
				foundStrongPassword = !passwordStreght.equals(STRONG);
			}
			return password.getPassword();
		}
		return "";
	}
	
	public String generateRandomString(int length) {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			switch (random.nextInt(4)) {
				case 0:
					builder.append(new Character((char) (48 + random.nextInt((57 + 1 - 48)))));
					break;
				case 1:
					builder.append(new Character((char) (97 + random.nextInt((122 + 1 - 97)))));
					break;
				case 2:
					builder.append(new Character((char) (65 + random.nextInt((90 + 1 - 65)))));
					break;
				case 3:
					builder.append(new Character(generateRandomSpecialCharacter()));
			}
		}
		return builder.toString();
	}
	
	private Character generateRandomSpecialCharacter() {
		Random random = new Random();
		switch (random.nextInt(3)) {
			case 0:
				return new Character((char) (33 + random.nextInt((47 + 1 - 33))));
			case 1:
				return new Character((char) (58 + random.nextInt((64 + 1 - 58))));
		}
		return new Character((char) (91 + random.nextInt((96 + 1 - 91))));
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

