package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.MockitoAnnotations.initMocks;
import static service.PasswordStrengthType.MEDIUM;
import static service.PasswordStrengthType.STRONG;
import static service.PasswordStrengthType.WEAK;

import java.util.ArrayList;
import java.util.List;

import model.Password;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import fixture.PasswordFixture;

public class PasswordStrengthServiceTest {
	
	@InjectMocks
	private PasswordStrengthService service;
	@Mock
	private PasswordCheckSize checkerSize;
	@Mock
	private PasswordCheckDictionary checkerDictionary;
	
	private Password password;
	private List<PasswordCheck> checkers;
	
	@Before
	public void setUp() {
		initMocks(this);
		checkers = new ArrayList<PasswordCheck>();
		checkers.add(checkerDictionary);
		checkers.add(checkerSize);
	}
	
	@Test
	public void shouldReturnTrueWhenWeightWeakPasswordIsMoreSignificantThanWeightMediumAndWeightStrong() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(30).withPercentualStrong(20).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightWeakPasswordIsNotMoreSignificantThanWeightMediumAndWeightStrong() {
		password = PasswordFixture.get().withPercentualWeak(20).withPercentualMedium(50).withPercentualStrong(30).build();
		assertFalse(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightWeakPasswordIsMoreSignificantThanWeightStrongButNotIsMoreSignificantThanWeightMedium() {
		password = PasswordFixture.get().withPercentualWeak(30).withPercentualMedium(50).withPercentualStrong(20).build();
		assertFalse(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightWeakPasswordIsMoreSignificantThanWeightMediumButNotIsMoreSignificantThanWeightStrong() {
		password = PasswordFixture.get().withPercentualWeak(30).withPercentualMedium(20).withPercentualStrong(50).build();
		assertFalse(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenWeightWeakDrawWithWeightMedium() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(50).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenWeightWeakDrawWithWeightStrong() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualStrong(50).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenWeightWeakDrawWithWeightMediumAndDrawWithWeightStrong() {
		password = PasswordFixture.get().withPercentualWeak(33.3).withPercentualMedium(33.3).withPercentualStrong(33.3).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	
	//
	@Test
	public void shouldReturnTrueWhenWeightMediumIsMoreSignificantThanWeightWeakAndWeightStrong() {
		password = PasswordFixture.get().withPercentualWeak(30).withPercentualMedium(50).withPercentualStrong(20).build();
		assertTrue(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightMediumNotIsMoreSignificantThanWeightWeakAndWeightStrong() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(20).withPercentualStrong(30).build();
		assertFalse(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenWeightMediumDrawWithWeightStrong() {
		password = PasswordFixture.get().withPercentualMedium(50).withPercentualStrong(50).build();
		assertTrue(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightMediumPasswordIsMoreSignificantThanWeightWeakButNotIsMoreSignificantThanWeightStrong() {
		password = PasswordFixture.get().withPercentualWeak(20).withPercentualMedium(30).withPercentualStrong(50).build();
		assertFalse(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightMediumPasswordIsMoreSignificantThanWeightStrongButNotIsMoreSignificantThanWeightWeak() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(30).withPercentualStrong(20).build();
		assertFalse(service.isMediumPassword(password));
	}
	
	
	//
	@Test
	public void shouldReturnTrueWhenWeightStrongIsMoreSignificantThanWeightWeakAndWeightMedium() {
		password = PasswordFixture.get().withPercentualWeak(30).withPercentualMedium(20).withPercentualStrong(50).build();
		assertTrue(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightStrongNotIsMoreSignificantThanWeightWeakAndWeightMedium() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(30).withPercentualStrong(20).build();
		assertFalse(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightStrongPasswordIsMoreSignificantThanWeightWeakButNotIsMoreSignificantThanWeightMedium() {
		password = PasswordFixture.get().withPercentualWeak(20).withPercentualMedium(50).withPercentualStrong(30).build();
		assertFalse(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightStrongPasswordIsMoreSignificantThanWeightMediumButNotIsMoreSignificantThanWeightWeak() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(20).withPercentualStrong(30).build();
		assertFalse(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldSetWeigthForWeakPasswords() {
		Password password = PasswordFixture.get().withPassword().build();
		
		given(checkerSize.checkPasswordStrength(any(Password.class))).willReturn(WEAK);
		given(checkerSize.getPonderation()).willReturn(30.0);
		given(checkerDictionary.checkPasswordStrength(any(Password.class))).willReturn(WEAK);
		given(checkerDictionary.getPonderation()).willReturn(20.0);
		
		service.applyWeight(password, checkers);
		
		assertEquals(50.0, password.getWeakWeight(), 0.0);
	}
	
	@Test
	public void shouldSetWeigthForMediumPasswords() {
		Password password = PasswordFixture.get().withPassword().build();
		
		given(checkerSize.checkPasswordStrength(any(Password.class))).willReturn(MEDIUM);
		given(checkerSize.getPonderation()).willReturn(30.0);
		given(checkerDictionary.checkPasswordStrength(any(Password.class))).willReturn(MEDIUM);
		given(checkerDictionary.getPonderation()).willReturn(20.0);
		
		service.applyWeight(password, checkers);
		
		assertEquals(50.0, password.getMediumWeight(), 0.0);
	}
	
	@Test
	public void shouldSetWeigthForStrongPasswords() {
		Password password = PasswordFixture.get().withPassword().build();
		
		given(checkerSize.checkPasswordStrength(any(Password.class))).willReturn(STRONG);
		given(checkerSize.getPonderation()).willReturn(30.0);
		given(checkerDictionary.checkPasswordStrength(any(Password.class))).willReturn(STRONG);
		given(checkerDictionary.getPonderation()).willReturn(20.0);
		
		service.applyWeight(password, checkers);
		
		assertEquals(50.0, password.getStrongWeigth(), 0.0);
	}
	
}
