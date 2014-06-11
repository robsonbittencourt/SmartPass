package encryption;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import model.RSAKeys;

public class RSAEncryption {
	
	public static void main(String[] args) {
		RSAEncryption encryption = new RSAEncryption();
		RSAKeys keys = new RSAKeys();
		keys.setFirst("2135836849");
		keys.setLastPublic("75151");
		keys.setLastPrivate("684985147");
		String encryptedText = encryption.encryptWithPublicKey(keys, "rua");
		String decryptedText = encryption.decryptWithPrivateKey(keys, encryptedText);
		System.out.println(encryptedText);
		System.out.println(decryptedText);
	}
	
	public String encryptWithPublicKey(RSAKeys keys, String plainText) {
		StringBuffer cryptedText = new StringBuffer();
		List<String> plainTextInBlocks = new ArrayList<String>();
		
		String plainTextInASCII = convertPlainTextToASCII(plainText);
				
		for (int i = 0; i < plainTextInASCII.length() - 2; i += 3) {
			plainTextInBlocks.add(plainTextInASCII.substring(i, i + 3));
		}
		
		for (String block : plainTextInBlocks) {
			BigInteger keyOne = new BigInteger(keys.getFirst());
			BigInteger keyTwo = new BigInteger(keys.getLastPublic());
			BigInteger letter = new BigInteger(block);
			
			BigInteger encrypted = letter.modPow(keyTwo, keyOne);
			cryptedText.append(encrypted);
		}
		return cryptedText.toString();
	}
	
	public String decryptWithPrivateKey(RSAKeys keys, String cryptedText) {
		StringBuffer decryptedText = new StringBuffer();
		List<String> cryptedBlocks = new ArrayList<String>();
		
		int blockSize = keys.getFirst().length();
		int stopCondition = cryptedText.length() - (blockSize - 1);
		
		for (int i = 0; i < stopCondition; i += blockSize) {
			cryptedBlocks.add(cryptedText.substring(i, i + (blockSize)));
		}
		
		for (String block : cryptedBlocks) {
			BigInteger keyOne = new BigInteger(keys.getFirst());
			BigInteger keyTwo = new BigInteger(keys.getLastPrivate());
			BigInteger cryptedLetter = new BigInteger(block);
			
			BigInteger decrypted = cryptedLetter.modPow(keyTwo, keyOne);
			
			System.out.println(decrypted);
			decryptedText.append((char)decrypted.intValue());
		}
				
		return decryptedText.toString();
	}
	
	public String convertPlainTextToASCII(String plainText) {
		StringBuffer cryptedLetters = new StringBuffer();
		
		for (int i = 0; i < plainText.length(); i++) {
			char character = plainText.charAt(i); 
			cryptedLetters.append(adjustEncrypted((int) character)); 
		}
		
		return cryptedLetters.toString();
	}

	private String adjustEncrypted(int encrypted) {
		String adjustedEncrypted = Integer.toString(encrypted);
		
		if(encrypted < 10)
			adjustedEncrypted = "00" + adjustedEncrypted;
		else if(encrypted < 100)
			adjustedEncrypted = "0" + adjustedEncrypted;
		
		return adjustedEncrypted;
	}


}
