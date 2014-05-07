package controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import model.Password;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import service.PasswordStrengthService;
import br.com.caelum.vraptor.util.test.MockResult;
import fixture.PasswordFixture;

public class PasswordStrengthControllerTest {
	
	@InjectMocks
	private PasswordStrengthController controller;
	@Mock
	private MockResult result;
	@Mock
	private PasswordStrengthService service;
	
	@Before
	public void setUp() {
		initMocks(this);
	}
	
	@Test
	public void shouldAddNewPasswordWhenAccessMainPage() {
		controller.passwordStrength();
		verify(result).include(any(Password.class));
	}
	
	@Test
	public void shouldNotVerifyPasswordStrengthWhenPasswordIsNull() {
		Password password = PasswordFixture.get().build();
		
		controller.passwordStrength(password);
		
		verify(service, never()).verifyPasswordStrenght(any(Password.class), any(List.class));
	}
	
}
