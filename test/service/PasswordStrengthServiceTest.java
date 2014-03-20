package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.MockitoAnnotations.initMocks;
import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;

import java.util.ArrayList;
import java.util.List;

import model.Password;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import check.PasswordCheck;
import check.PasswordCheckDictionary;
import check.PasswordCheckSize;
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
		password = PasswordFixture.get().withWeakWeight(50).withMediumWeight(30).withStrongWeight(20).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightWeakPasswordIsNotMoreSignificantThanWeightMediumAndWeightStrong() {
		password = PasswordFixture.get().withWeakWeight(20).withMediumWeight(50).withStrongWeight(30).build();
		assertFalse(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightWeakPasswordIsMoreSignificantThanWeightStrongButNotIsMoreSignificantThanWeightMedium() {
		password = PasswordFixture.get().withWeakWeight(30).withMediumWeight(50).withStrongWeight(20).build();
		assertFalse(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightWeakPasswordIsMoreSignificantThanWeightMediumButNotIsMoreSignificantThanWeightStrong() {
		password = PasswordFixture.get().withWeakWeight(30).withMediumWeight(20).withStrongWeight(50).build();
		assertFalse(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenWeightWeakDrawWithWeightMedium() {
		password = PasswordFixture.get().withWeakWeight(50).withMediumWeight(50).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenWeightWeakDrawWithWeightStrong() {
		password = PasswordFixture.get().withWeakWeight(50).withStrongWeight(50).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenWeightWeakDrawWithWeightMediumAndDrawWithWeightStrong() {
		password = PasswordFixture.get().withWeakWeight(33.3).withMediumWeight(33.3).withStrongWeight(33.3).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	
	//
	@Test
	public void shouldReturnTrueWhenWeightMediumIsMoreSignificantThanWeightWeakAndWeightStrong() {
		password = PasswordFixture.get().withWeakWeight(30).withMediumWeight(50).withStrongWeight(20).build();
		assertTrue(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightMediumNotIsMoreSignificantThanWeightWeakAndWeightStrong() {
		password = PasswordFixture.get().withWeakWeight(50).withMediumWeight(20).withStrongWeight(30).build();
		assertFalse(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenWeightMediumDrawWithWeightStrong() {
		password = PasswordFixture.get().withMediumWeight(50).withStrongWeight(50).build();
		assertTrue(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightMediumPasswordIsMoreSignificantThanWeightWeakButNotIsMoreSignificantThanWeightStrong() {
		password = PasswordFixture.get().withWeakWeight(20).withMediumWeight(30).withStrongWeight(50).build();
		assertFalse(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightMediumPasswordIsMoreSignificantThanWeightStrongButNotIsMoreSignificantThanWeightWeak() {
		password = PasswordFixture.get().withWeakWeight(50).withMediumWeight(30).withStrongWeight(20).build();
		assertFalse(service.isMediumPassword(password));
	}
	
	
	//
	@Test
	public void shouldReturnTrueWhenWeightStrongIsMoreSignificantThanWeightWeakAndWeightMedium() {
		password = PasswordFixture.get().withWeakWeight(30).withMediumWeight(20).withStrongWeight(50).build();
		assertTrue(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightStrongNotIsMoreSignificantThanWeightWeakAndWeightMedium() {
		password = PasswordFixture.get().withWeakWeight(50).withMediumWeight(30).withStrongWeight(20).build();
		assertFalse(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightStrongPasswordIsMoreSignificantThanWeightWeakButNotIsMoreSignificantThanWeightMedium() {
		password = PasswordFixture.get().withWeakWeight(20).withMediumWeight(50).withStrongWeight(30).build();
		assertFalse(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenWeightStrongPasswordIsMoreSignificantThanWeightMediumButNotIsMoreSignificantThanWeightWeak() {
		password = PasswordFixture.get().withWeakWeight(50).withMediumWeight(20).withStrongWeight(30).build();
		assertFalse(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldSetWeigthForWeakPasswords() {
		Password password = PasswordFixture.get().withPassword().build();
		
		given(checkerSize.checkPasswordStrength(any(Password.class))).willReturn(WEAK);
		given(checkerSize.getWeigth()).willReturn(30.0);
		given(checkerDictionary.checkPasswordStrength(any(Password.class))).willReturn(WEAK);
		given(checkerDictionary.getWeigth()).willReturn(20.0);
		
		service.applyWeight(password, checkers);
		
		assertEquals(50.0, password.getWeakWeight(), 0.0);
	}
	
	@Test
	public void shouldSetWeigthForMediumPasswords() {
		Password password = PasswordFixture.get().withPassword().build();
		
		given(checkerSize.checkPasswordStrength(any(Password.class))).willReturn(MEDIUM);
		given(checkerSize.getWeigth()).willReturn(30.0);
		given(checkerDictionary.checkPasswordStrength(any(Password.class))).willReturn(MEDIUM);
		given(checkerDictionary.getWeigth()).willReturn(20.0);
		
		service.applyWeight(password, checkers);
		
		assertEquals(50.0, password.getMediumWeight(), 0.0);
	}
	
	@Test
	public void shouldSetWeigthForStrongPasswords() {
		Password password = PasswordFixture.get().withPassword().build();
		
		given(checkerSize.checkPasswordStrength(any(Password.class))).willReturn(STRONG);
		given(checkerSize.getWeigth()).willReturn(30.0);
		given(checkerDictionary.checkPasswordStrength(any(Password.class))).willReturn(STRONG);
		given(checkerDictionary.getWeigth()).willReturn(20.0);
		
		service.applyWeight(password, checkers);
		
		assertEquals(50.0, password.getStrongWeigth(), 0.0);
	}
	
}
