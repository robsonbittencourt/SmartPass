package encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.caelum.vraptor.ioc.Component;
 
@Component
public class MD5 {
	
	public String generateHash(String text) {
        try {
        	MessageDigest m = MessageDigest.getInstance("MD5");
        	m.reset();
        	m.update(text.getBytes());
        	byte[] digest = m.digest();
        	BigInteger bigInt = new BigInteger(1,digest);
        	String hashtext = bigInt.toString(16);

        	while(hashtext.length() < 32 ){
        	  hashtext = "0"+hashtext;
        	}
        	
        	return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}