package encryption;

import br.com.caelum.vraptor.ioc.Component;
 
@Component
public class CaesarCipher {
	
	public String encrypt(int encryptionKey, String plainText){
		StringBuilder cipheredText = new StringBuilder();
		int plainTextLength = plainText.length();
		
		for(int i=0; i < plainTextLength; i++){
			int cryptedLetterASCII = ((int)plainText.charAt(i)) + encryptionKey;
			
			while(cryptedLetterASCII > 126)
				cryptedLetterASCII -= 94;
 
			cipheredText.append((char)cryptedLetterASCII);
		}
		
		return cipheredText.toString();
	}
	
	public String decrypt(int encryptionKey, String cipherText){
		StringBuilder texto = new StringBuilder();
		int cipheredTextLength = cipherText.length();
		
		for(int i=0; i < cipheredTextLength; i++){
			int decryptedLetterASCII = ((int)cipherText.charAt(i)) - encryptionKey;
			
			while(decryptedLetterASCII < 32)
				decryptedLetterASCII += 94;
 
			texto.append((char)decryptedLetterASCII);
		}
		
		return texto.toString();
	}
	
}