package check;

import static org.junit.Assert.assertEquals;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;
import model.Password;

import org.junit.Before;
import org.junit.Test;

import fixture.PasswordFixture;

public class PasswordCheckDictionaryTest {

	private PasswordCheckDictionary checker;

	@Before
	public void setUp() {
		checker = new PasswordCheckDictionary(20);
	}

	@Test
	public void shouldReturnWeakWhenPasswordExistsInDictionary() {
		Password password = PasswordFixture.get().withPassword("casa").build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}

	@Test
	public void shouldReturnStrongWhenPasswordDoNotExistsInDictionary() {
		Password password = PasswordFixture.get().withPassword("carro").build();
		assertEquals(STRONG, checker.checkPasswordStrength(password));
	}
}
