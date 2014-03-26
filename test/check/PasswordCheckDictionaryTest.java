package check;

import static org.junit.Assert.assertEquals;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;
import model.Password;

import org.junit.Before;
import org.junit.Test;

import fixture.PasswordFixture;

public class PasswordCheckDictionaryTest {

	private static final String WORD_DOES_NOT_EXISTS_IN_DICTIONARY = "tdgsj";
	private static final String WORD_EXISTS_IN_DICTIONARY = "casa";
	
	private PasswordCheckDictionary checker;

	@Before
	public void setUp() {
		checker = new PasswordCheckDictionary(20);
	}

	@Test
	public void shouldReturnWeakWhenPasswordExistsInDictionary() {
		Password password = PasswordFixture.get().withPassword(WORD_EXISTS_IN_DICTIONARY).build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}

	@Test
	public void shouldReturnStrongWhenPasswordDoNotExistsInDictionary() {
		Password password = PasswordFixture.get().withPassword(WORD_DOES_NOT_EXISTS_IN_DICTIONARY).build();
		assertEquals(STRONG, checker.checkPasswordStrength(password));
	}
}
