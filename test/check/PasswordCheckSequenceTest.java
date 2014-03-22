package check;

import static org.junit.Assert.assertEquals;
import static type.PasswordStrengthType.MEDIUM;
import static type.PasswordStrengthType.STRONG;
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
	public void shouldReturnWeakWhenPasswordContainAscendantNumericalSequenceWithFourOrMoreNumbers() {
		Password password = PasswordFixture.get().withPassword("anyThing1234anyThing").build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainDescendantNumericalSequenceWithFourOrMoreNumbers() {
		Password password = PasswordFixture.get().withPassword("anyThing54321anyThing").build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainAscendantAlphabeticSequenceWithFourOrMoreLetters() {
		Password password = PasswordFixture.get().withPassword("anyThingAbCdEanyThing").build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainDescendantAlphabeticSequenceWithFourOrMoreLetters() {
		Password password = PasswordFixture.get().withPassword("anyThingDcBaanyThing").build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainEqualsNumericSequenceWithFourOrMoreNumbers() {
		Password password = PasswordFixture.get().withPassword("anyThing3333anyThing").build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainEqualsAlphabeticSequenceWithFourOrMoreLetters() {
		Password password = PasswordFixture.get().withPassword("anyThingaAaAanyThing").build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainAscendantNumericalSequenceWithThreeNumbers() {
		Password password = PasswordFixture.get().withPassword("anyThing123anyThing").build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainDescendantNumericalSequenceWithThreeNumbers() {
		Password password = PasswordFixture.get().withPassword("anyThing321anyThing").build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainAscendantAlphabeticSequenceWithThreeLetters() {
		Password password = PasswordFixture.get().withPassword("anyThingaBcanyThing").build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainDescendantAlphabeticSequenceWithThreeLetters() {
		Password password = PasswordFixture.get().withPassword("anyThingcBaanyThing").build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainEqualsNumericSequenceWithThreeNumbers() {
		Password password = PasswordFixture.get().withPassword("anyThing333anyThing").build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainEqualsAlphabeticSequenceWithThreeLetters() {
		Password password = PasswordFixture.get().withPassword("anyThingBbBanyThing").build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
		
	@Test
	public void shouldReturnStrongWhenPasswordDoesNotContainAnySequenceWithMoreThanTwoNumbersOrLetters() {
		Password password = PasswordFixture.get().withPassword("132469yhdsoljjs").build();
		assertEquals(STRONG, checker.checkPasswordStrength(password));
	}
	
}
