package encryption;

import java.util.ArrayList;
import java.util.List;

import model.RSAKeys;

public class RSAEncryption {
	
	public String encryptWithPublicKey(RSAKeys keys, String plainText) {
		StringBuffer cryptedText = new StringBuffer();
		List<Integer> plainTextInASCII = convertPlainTextToASCII(plainText);
		
		for (Integer letter : plainTextInASCII) {
			cryptedText.append((int)Math.pow(letter, Integer.parseInt(keys.getLastPublic()) % Integer.parseInt(keys.getFirst())));
		}
		
		return cryptedText.toString();
	}
	
	public String decryptWithPrivateKey(RSAKeys keys, String cryptedText) {
		StringBuffer decryptedText = new StringBuffer();
		List<Integer> cryptedBlocks = new ArrayList<Integer>();
		
		for (int i = 0; i < cryptedText.length() - 2; i = i + 3) {
			cryptedBlocks.add(Integer.parseInt(cryptedText.substring(i, i + 2)));
		}
		
		for (Integer block : cryptedBlocks) {
			decryptedText.append((int)Math.pow(block, Integer.parseInt(keys.getLastPrivate()) % Integer.parseInt(keys.getFirst())));
		}
				
		return decryptedText.toString();
	}
	
	//TODO: Precisa colocar um zero na frente quando for menor 100.
	public List<Integer> convertPlainTextToASCII(String plainText) {
		List<Integer> cryptedLetters = new ArrayList<Integer>();
		
		for (int i = 0; i < plainText.length(); i++) {
			char character = plainText.charAt(i); 
			cryptedLetters.add((int) character); 
		}
		
		return cryptedLetters;
	}

}
