package service;


import model.Password;

import org.junit.Test;

import type.PasswordStrengthType;
import static org.junit.Assert.*;
import fixture.PasswordFixture;


public class PasswordCheckCharacterTypesTest {
	
	@Test
	public void shouldReturnWeakWhenPasswordContainsOnlyLetters() {
		PasswordCheckCharacterTypes checker = new PasswordCheckCharacterTypes(20);
		Password password = PasswordFixture.get().withPassword("sWqeW").build();
		assertEquals(PasswordStrengthType.WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainUpperAndLowercaseLettersAndAtLeastOneNumber() {
		PasswordCheckCharacterTypes checker = new PasswordCheckCharacterTypes(30);
		Password password = PasswordFixture.get().withPassword("sWq8eW").build();
		assertEquals(PasswordStrengthType.MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnStrongWhenPasswordContainUpperAndLowercaseLettersAtLeastOneNumberAndAtLeastSpecialCharacter() {
		PasswordCheckCharacterTypes checker = new PasswordCheckCharacterTypes(30);
		Password password = PasswordFixture.get().withPassword("s&Wq8eW").build();
		assertEquals(PasswordStrengthType.STRONG, checker.checkPasswordStrength(password));
	}
}
