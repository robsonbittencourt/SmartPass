package encryption;

import com.google.inject.Inject;

import br.com.caelum.vraptor.ioc.Component;
import model.RSAKeys;
import helper.RandomHelper;

@Component
public class RSAKeysGenerator {
	
	private static final int LAST_ASCII_CODE = 127;
	
	@Inject
	private RandomHelper randomHelper = new RandomHelper();
	
	public RSAKeys createKeys() {
		while(true) {
			int p = getRandomPrimeNumber();
			int q = getRandomPrimeNumber();
			int n = getVariableN(p, q);
			
			if(n == 0)
				continue;
			
			int z = getVariableZ(p, q);
			int e = getVariableE(z);
			int d = getVariableD(e, z);
			
			if(d == 0)
				continue;
			
			if (isValidVariablesCombination(p, q, n, z, e, d)){
				RSAKeys keys = new RSAKeys();
				keys.setFirst(Integer.toString(n));
				keys.setLastPublic(Integer.toString(e));
				keys.setLastPrivate(Integer.toString(d));
				return keys;
			}	
		}
	}
	
	private int getVariableN(int p, int q) {
		int n = p * q;
		if(n > LAST_ASCII_CODE)
			return n;
		else 
			return 0;
	}
	
	private int getVariableZ(int p, int q) {
		return (p - 1) * (q - 1);
	}
	
	private int getVariableE(int z) {
		while(true) {
			int randomInteger = randomHelper.getRandomPositiveInteger();
			if(isCoPrimeNumbers(z, randomInteger)){
				return randomInteger;
			}	
		}
	}
	
	private int getVariableD(int e, int z) {
		int d = 1;
		while(true) {
			if(d > 999999999)
				return 0;
			if(((e * d) % z) == 1)
				return d;
			else 
				d++;
		}
	}
	
	private boolean isValidVariablesCombination(int p, int q, int n, int z, int e, int d) {
		if((p != q) && (p != n) && (p != z) && (p != e) && (p != d) && (q != n) && (q != z) &&
			(q != e) && (q != d) && (n != z) && (n != e) && (n != d) && (z != e) && (z != d) && (e != d)){
			
			return true;
		}
		
		return false;
	}
	
	private int getRandomPrimeNumber() {
		while(true) {
			int randomInteger = randomHelper.getRandomPositiveInteger();
			if(isPrimeNumber(randomInteger)) 
				return randomInteger;
		}
	}
	
	private boolean isPrimeNumber(int n) {
		if (n % 2 == 0)
		   	return false;
		
		for(int i=3;i*i<=n;i+=2) {
			if(n%i==0)
		      	return false;
		}
		return true;
	}
	
	private boolean isCoPrimeNumbers(int x, int y) {
		while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x == 1 ? true : false;
	}
	
}
