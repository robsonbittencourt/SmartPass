package service;

import static type.PasswordStrengthType.WEAK;
import model.Password;
import static org.junit.Assert.*;

import org.junit.Test;

import fixture.PasswordFixture;


public class PassworCheckSequenceTest {
	
	@Test
	public void shouldReturnWeakWhenPasswordContainsNumericalSequenceWithFourNumbers() {
		PassworCheckSequence checker = new PassworCheckSequence(10);
		Password password = PasswordFixture.get().withPassword("1234").build();
			
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
}
