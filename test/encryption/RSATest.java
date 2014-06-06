package encryption;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RSATest {
	
	private RSA rsa;
	
	@Before
	public void setUp() {
		rsa = new RSA();
	}
	
	@Test
	public void shouldReturnTrueForPrimeNumbers() {
		RSA rsa = new RSA();
		assertTrue(rsa.isPrimeNumber(7));
	}
	
	@Test
	public void shouldReturnFalseForNoPrimeNumbers() {
		RSA rsa = new RSA();
		assertFalse(rsa.isPrimeNumber(6));
	}
	
	@Test
	public void shouldBeCoPrimeWhenInformedTenAndSeven() {
		RSA rsa = new RSA();
		assertTrue(rsa.isCoPrimeNumbers(10, 7));
	}
	
	@Test
	public void shouldDoNotBeCoPrimeWhenInformedTenAndFive() {
		RSA rsa = new RSA();
		assertFalse(rsa.isCoPrimeNumbers(10, 5));
	}
	
	@Test
	public void shouldReturnRandomPrimeNumber() {
		int number = rsa.getRandomPrimeNumber();
		assertTrue(rsa.isPrimeNumber(number));
	}
	
	@Test
	public void test(){
		rsa.generateVariableE();
		System.out.println(rsa.e);
	}
	
}
