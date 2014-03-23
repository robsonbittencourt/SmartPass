package check;

import static org.junit.Assert.assertEquals;
import model.Password;

import org.junit.Before;
import org.junit.Test;

import type.PasswordStrengthType;
import fixture.PasswordFixture;

public class PasswordCheckCharacterTypesTest {
	
	private static final String UPPER_AND_LOWER_CASE_AND_NUMBER_AND_SPECIAL_CHARACTER = "s&Wq8eW";
	private static final String UPPER_AND_LOWER_CASE_AND_NUMBER = "sWq8eW";
	private static final String ONLY_LETTERS = "sWqeW";
	
	private PasswordCheckCharacterTypes checker;
	
	@Before
	public void setUp() {
		checker = new PasswordCheckCharacterTypes(20);
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainsOnlyLetters() {
		Password password = PasswordFixture.get().withPassword(ONLY_LETTERS).build();
		assertEquals(PasswordStrengthType.WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainUpperAndLowercaseLettersAndAtLeastOneNumber() {
		Password password = PasswordFixture.get().withPassword(UPPER_AND_LOWER_CASE_AND_NUMBER).build();
		assertEquals(PasswordStrengthType.MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnStrongWhenPasswordContainUpperAndLowercaseLettersAtLeastOneNumberAndAtLeastSpecialCharacter() {
		Password password = PasswordFixture.get().withPassword(UPPER_AND_LOWER_CASE_AND_NUMBER_AND_SPECIAL_CHARACTER).build();
		assertEquals(PasswordStrengthType.STRONG, checker.checkPasswordStrength(password));
	}
}
