package controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static type.PasswordStrengthType.WEAK;

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
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldVerifyPasswordStrength() {
		Password password = PasswordFixture.get().withPassword().build();
		
		given(service.verifyPasswordStrenght(eq(password), any(List.class))).willReturn(WEAK);
		
		controller.passwordStrength(password);
		
		assertEquals(WEAK.getStatus(), password.getStatus());
		verify(result).include(same("password"), any(Password.class));
	}
	
}
