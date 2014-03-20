package check;
import static org.junit.Assert.assertEquals;
import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.WEAK;
import model.Password;

import org.junit.Test;

import check.PasswordCheckDate;
import fixture.PasswordFixture;

public class PasswordCheckDateTest {
	
	@Test
	public void shouldReturnWeakWhenPasswordContainsDateWithFormatXX_XX_XXXX() {
		PasswordCheckDate checker = new PasswordCheckDate(10);
		Password password = PasswordFixture.get().withPassword("12102014").build();
			
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainsDateWithFormatXX_XX_XX() {
		PasswordCheckDate checker = new PasswordCheckDate(10);
		Password password = PasswordFixture.get().withPassword("121014").build();
			
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
}
