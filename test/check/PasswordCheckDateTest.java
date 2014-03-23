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
	
	private static final String WITHOUT_DATE = "anyThing321417anyThing";
	private static final String DATE_IN_FORMAT_XX_XX_XX = "anyThing121014anyThing";
	private static final String DATE_IN_FORMAT_XX_XX_XXXX = "anyThing12102014anyThing";
	
	private PasswordCheckDate checker;
	
	@Before
	public void setUp() {
		checker = new PasswordCheckDate(10);
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainsDateWithFormatXX_XX_XXXX() {
		Password password = PasswordFixture.get().withPassword(DATE_IN_FORMAT_XX_XX_XXXX).build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainsDateWithFormatXX_XX_XX() {
		Password password = PasswordFixture.get().withPassword(DATE_IN_FORMAT_XX_XX_XX).build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnStrongWhenPasswordNotContainsAnyDatePattern() {
		Password password = PasswordFixture.get().withPassword(WITHOUT_DATE).build();
		assertEquals(STRONG, checker.checkPasswordStrength(password));
	}
}
