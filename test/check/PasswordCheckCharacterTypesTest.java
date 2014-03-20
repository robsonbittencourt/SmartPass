package check;


import static org.junit.Assert.assertEquals;
import model.Password;

import org.junit.Before;
import org.junit.Test;

import type.PasswordStrengthType;
import fixture.PasswordFixture;


public class PasswordCheckCharacterTypesTest {
	
	private PasswordCheckCharacterTypes checker;
	
	@Before
	public void setUp() {
		checker = new PasswordCheckCharacterTypes(20);
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainsOnlyLetters() {
		Password password = PasswordFixture.get().withPassword("sWqeW").build();
		assertEquals(PasswordStrengthType.WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainUpperAndLowercaseLettersAndAtLeastOneNumber() {
		Password password = PasswordFixture.get().withPassword("sWq8eW").build();
		assertEquals(PasswordStrengthType.MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnStrongWhenPasswordContainUpperAndLowercaseLettersAtLeastOneNumberAndAtLeastSpecialCharacter() {
		Password password = PasswordFixture.get().withPassword("s&Wq8eW").build();
		assertEquals(PasswordStrengthType.STRONG, checker.checkPasswordStrength(password));
	}
}
