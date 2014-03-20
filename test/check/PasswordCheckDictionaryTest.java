package check;

import static org.junit.Assert.assertEquals;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;
import model.Password;

import org.junit.Test;

import check.PasswordCheckDictionary;


public class PasswordCheckDictionaryTest {
	
	@Test
	public void shouldReturnWeakWhenPasswordExistsInDictionary() {
		PasswordCheckDictionary checkDictionary = new PasswordCheckDictionary(20);
		Password password = new Password();
		password.setPassword("casa");
		assertEquals(WEAK, checkDictionary.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnStrongWhenPasswordDoNotExistsInDictionary() {
		PasswordCheckDictionary checkDictionary = new PasswordCheckDictionary(20);
		Password password = new Password();
		password.setPassword("carro");
		assertEquals(STRONG, checkDictionary.checkPasswordStrength(password));
	}
}
