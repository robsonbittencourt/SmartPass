package check;

import static org.junit.Assert.assertEquals;
import static type.PasswordStrengthType.WEAK;
import model.Password;

import org.junit.Before;
import org.junit.Test;

import fixture.PasswordFixture;


public class PasswordCheckSequenceTest {
	
	private PasswordCheckSequence checker;
	
	@Before
	public void setUp() {
		checker = new PasswordCheckSequence(10);
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainsNumericalSequenceWithFourNumbers() {
		Password password = PasswordFixture.get().withPassword("1234").build();
			
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
}
