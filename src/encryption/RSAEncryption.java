package encryption;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import model.RSAKeys;

public class RSAEncryption {
	
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
			cryptedText.append(adjustEncrypted(Integer.parseInt(encrypted.toString()), keys.getFirst().length()));
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
			
			decryptedText.append((char)decrypted.intValue());
		}
				
		return decryptedText.toString();
	}
	
	public String convertPlainTextToASCII(String plainText) {
		StringBuffer cryptedLetters = new StringBuffer();
		
		for (int i = 0; i < plainText.length(); i++) {
			char character = plainText.charAt(i); 
			cryptedLetters.append(adjustEncrypted((int) character, 3)); 
		}
		
		return cryptedLetters.toString();
	}

	private String adjustEncrypted(int encrypted, int targetSize) {
		String adjustedEncrypted = Integer.toString(encrypted);
		
		if(adjustedEncrypted.length() < targetSize)
			for (int i = 0; i < targetSize - adjustedEncrypted.length(); i++) {
				adjustedEncrypted = "0" + adjustedEncrypted;
			}
			
		return adjustedEncrypted;
	}


}
