package check;
import static org.junit.Assert.assertEquals;
import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;
import model.Password;

import org.junit.Before;
import org.junit.Test;

import fixture.PasswordFixture;

public class PasswordCheckDateTest {
	
	private PasswordCheckDate checker;
	
	@Before
	public void setUp() {
		checker = new PasswordCheckDate(10);
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainsDateWithFormatXX_XX_XXXX() {
		Password password = PasswordFixture.get().withPassword("12102014").build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainsDateWithFormatXX_XX_XX() {
		Password password = PasswordFixture.get().withPassword("121014").build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnStrongmWhenPasswordNotContainsAnyDatePattern() {
		Password password = PasswordFixture.get().withPassword("1221017").build();
		assertEquals(STRONG, checker.checkPasswordStrength(password));
	}
}
