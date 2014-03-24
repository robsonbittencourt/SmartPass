package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static type.PasswordStrengthType.*;

import java.util.List;

import model.Password;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class GeneratePasswordServiceTest {
	
	@InjectMocks
	private GeneratePasswordService service;
	@Mock
	private PasswordStrengthService passwordStrengthService;
	
	@Before
	public void setUp() {
		initMocks(this);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldReturnStrongPasswordWhenRandomPasswordIsStrong() {
		given(passwordStrengthService.verifyPasswordStrenght(any(Password.class), any(List.class))).willReturn(STRONG);
		
		String generatedPassword = service.generateRandomStrongPassword(10);
		
		verify(passwordStrengthService, times(1)).verifyPasswordStrenght(any(Password.class), any(List.class));
		assertEquals(10, generatedPassword.length());
	}
}
