package check;

import static type.PasswordStrengthType.WEAK;
import model.Password;
import static org.junit.Assert.*;

import org.junit.Test;

import check.PasswordCheckSequence;
import fixture.PasswordFixture;


public class PasswordCheckSequenceTest {
	
	@Test
	public void shouldReturnWeakWhenPasswordContainsNumericalSequenceWithFourNumbers() {
		PasswordCheckSequence checker = new PasswordCheckSequence(10);
		Password password = PasswordFixture.get().withPassword("1234").build();
			
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
}
