package encryption;

import helper.RandomHelper;

public class RSA {
	
	private static final int LAST_ASCII_CODE = 127;
	private RandomHelper randomHelper = new RandomHelper();
	
	private int p;
	private int q;
	public int e;
	
	public void generateVariablePandVariableQ() {
		p = getRandomPrimeNumber();
		q = getRandomPrimeNumber();
	}
	
	public int getVariableN() {
		while(true) {
			int n = p * q;
			if(n > LAST_ASCII_CODE)
				return n;
		}
	}
	
	public int getVariableZ() {
		generateVariablePandVariableQ();
		return (p - 1) * (q - 1);
	}
	
	public void generateVariableE() {
		while(true) {
			int randomInteger = randomHelper.getRandomPositiveInteger();
			if(isCoPrimeNumbers(getVariableZ(), randomInteger)){
				e = randomInteger;
				return;
			}	
		}
	}
	
	public int getRandomPrimeNumber() {
		while(true) {
			int randomInteger = randomHelper.getRandomPositiveInteger();
			if(isPrimeNumber(randomInteger)) 
				return randomInteger;
		}
	}
	
	public boolean isPrimeNumber(int n) {
		if (n % 2 == 0)
		   	return false;
		
		for(int i=3;i*i<=n;i+=2) {
			if(n%i==0)
		      	return false;
		}
		return true;
	}
	
	public boolean isCoPrimeNumbers(int x, int y) {
		while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x == 1 ? true : false;
	}

	
}
