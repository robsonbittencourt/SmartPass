package check;

import static org.junit.Assert.assertEquals;
import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;
import model.Password;

import org.junit.Before;
import org.junit.Test;

import check.PasswordCheckSize;
import fixture.PasswordFixture;

public class PasswordCheckSizeTest {
	
	private PasswordCheckSize checker;
	
	@Before
	public void setUp() {
		checker = new PasswordCheckSize(30);
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordLengthIsLessOfFour() {
		Password password = PasswordFixture.get().withPassword("123").build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordLengthIsBiggerToFourAndLessToNine() {
		Password password = PasswordFixture.get().withPassword("12345").build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnStrongWhenPasswordLengthIsBiggerToEight() {
		Password password = PasswordFixture.get().withPassword("123456789").build();
		assertEquals(STRONG, checker.checkPasswordStrength(password));
	}
}
