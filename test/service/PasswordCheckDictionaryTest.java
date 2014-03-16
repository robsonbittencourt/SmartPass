package service;

import static org.junit.Assert.assertEquals;
import static service.PasswordStrengthType.STRONG;
import static service.PasswordStrengthType.WEAK;
import model.Password;

import org.junit.Test;


public class PasswordCheckDictionaryTest {
	
	@Test
	public void shouldReturnWeakWhenPasswordExistsInDictionary() {
		PasswordCheckDictionary checkDictionary = new PasswordCheckDictionary();
		Password password = new Password();
		password.setPassword("casa");
		assertEquals(WEAK, checkDictionary.checkPassword(password));
	}
	
	@Test
	public void shouldReturnStrongWhenPasswordDoNotExistsInDictionary() {
		PasswordCheckDictionary checkDictionary = new PasswordCheckDictionary();
		Password password = new Password();
		password.setPassword("carro");
		assertEquals(STRONG, checkDictionary.checkPassword(password));
	}
}
