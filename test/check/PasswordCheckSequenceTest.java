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
	
	private static final String WITHOUT_ANY_SEQUENCE = "132469yhdsoljjs";
	private static final String EQUALS_ALPHABETICAL_SEQUENCE_SIZE_3 = "anyThingBbBanyThing";
	private static final String EQUALS_NUMERIC_SEQUENCE_SIZE_3 = "anyThing333anyThing";
	private static final String DESCENDANT_ALPHABETICAL_SEQUENCE_SIZE_3 = "anyThingcBaanyThing";
	private static final String ASCENDANT_ALPHABETICAL_SEQUENCE_SIZE_3 = "anyThingaBcanyThing";
	private static final String DESCENDANT_NUMERICAL_SEQUENCE_SIZE_3 = "anyThing321anyThing";
	private static final String ASCENDANT_NUMERICAL_SEQUENCE_SIZE_3 = "anyThing123anyThing";
	private static final String EQUALS_ALPHABETICAL_SEQUENCE_SIZE_4 = "anyThingaAaAanyThing";
	private static final String EQUALS_NUMERIC_SEQUENCE_SIZE_4 = "anyThing3333anyThing";
	private static final String DESCENDANT_ALPHABETICAL_SEQUENCE_SIZE_4 = "anyThingDcBaanyThing";
	private static final String ASCENDANT_ALPHABETICAL_SEQUENCE_SIZE_5 = "anyThingAbCdEanyThing";
	private static final String DESCENDANT_NUMERICAL_SEQUENCE_SIZE_5 = "anyThing54321anyThing";
	private static final String ASCENDANT_NUMERICAL_SEQUENCE_SIZE_4 = "anyThing1234anyThing";
	
	private PasswordCheckSequence checker;
	
	@Before
	public void setUp() {
		checker = new PasswordCheckSequence(10);
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainAscendantNumericalSequenceWithFourOrMoreNumbers() {
		Password password = PasswordFixture.get().withPassword(ASCENDANT_NUMERICAL_SEQUENCE_SIZE_4).build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainDescendantNumericalSequenceWithFourOrMoreNumbers() {
		Password password = PasswordFixture.get().withPassword(DESCENDANT_NUMERICAL_SEQUENCE_SIZE_5).build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainAscendantAlphabeticSequenceWithFourOrMoreLetters() {
		Password password = PasswordFixture.get().withPassword(ASCENDANT_ALPHABETICAL_SEQUENCE_SIZE_5).build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainDescendantAlphabeticSequenceWithFourOrMoreLetters() {
		Password password = PasswordFixture.get().withPassword(DESCENDANT_ALPHABETICAL_SEQUENCE_SIZE_4).build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainEqualsNumericSequenceWithFourOrMoreNumbers() {
		Password password = PasswordFixture.get().withPassword(EQUALS_NUMERIC_SEQUENCE_SIZE_4).build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordContainEqualsAlphabeticSequenceWithFourOrMoreLetters() {
		Password password = PasswordFixture.get().withPassword(EQUALS_ALPHABETICAL_SEQUENCE_SIZE_4).build();
		assertEquals(WEAK, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainAscendantNumericalSequenceWithThreeNumbers() {
		Password password = PasswordFixture.get().withPassword(ASCENDANT_NUMERICAL_SEQUENCE_SIZE_3).build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainDescendantNumericalSequenceWithThreeNumbers() {
		Password password = PasswordFixture.get().withPassword(DESCENDANT_NUMERICAL_SEQUENCE_SIZE_3).build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainAscendantAlphabeticSequenceWithThreeLetters() {
		Password password = PasswordFixture.get().withPassword(ASCENDANT_ALPHABETICAL_SEQUENCE_SIZE_3).build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainDescendantAlphabeticSequenceWithThreeLetters() {
		Password password = PasswordFixture.get().withPassword(DESCENDANT_ALPHABETICAL_SEQUENCE_SIZE_3).build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainEqualsNumericSequenceWithThreeNumbers() {
		Password password = PasswordFixture.get().withPassword(EQUALS_NUMERIC_SEQUENCE_SIZE_3).build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordContainEqualsAlphabeticSequenceWithThreeLetters() {
		Password password = PasswordFixture.get().withPassword(EQUALS_ALPHABETICAL_SEQUENCE_SIZE_3).build();
		assertEquals(MEDIUM, checker.checkPasswordStrength(password));
	}
		
	@Test
	public void shouldReturnStrongWhenPasswordDoesNotContainAnySequenceWithMoreThanTwoNumbersOrLetters() {
		Password password = PasswordFixture.get().withPassword(WITHOUT_ANY_SEQUENCE).build();
		assertEquals(STRONG, checker.checkPasswordStrength(password));
	}
	
}
