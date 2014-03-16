package service;

import static org.junit.Assert.*;
import model.Password;

import org.junit.Test;

import static service.PasswordStrengthType.*;

public class PasswordCheckSizeTest {

	@Test
	public void shouldReturnWeakWhenPasswordLengthIsLessOfFour() {
		PasswordCheckSize checkSize = new PasswordCheckSize();
		Password password = new Password();
		password.setPassword("123");
		
		assertEquals(checkSize.checkPassword(password), WEAK);
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordLengthIsBiggerToFourAndLessToEigth() {
		PasswordCheckSize checkSize = new PasswordCheckSize();
		Password password = new Password();
		password.setPassword("12345");
		
		assertEquals(checkSize.checkPassword(password), MEDIUM);
	}
	
	@Test
	public void shouldReturnStrongWhenPasswordLengthIsBiggerToSeven() {
		PasswordCheckSize checkSize = new PasswordCheckSize();
		Password password = new Password();
		password.setPassword("12345678");
		
		assertEquals(checkSize.checkPassword(password), STRONG);
	}
}
