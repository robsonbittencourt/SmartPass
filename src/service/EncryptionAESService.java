//Adapting for: https://gist.github.com/bricef/2436364

package service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionAESService {

	private static final int BLOCK_SIZE = 16;

	public byte[] encrypt(String plainText, String encryptionKey, String IV) throws Exception {
		plainText = fillString(plainText);
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return cipher.doFinal(plainText.getBytes("UTF-8"));
	}

	public String decrypt(byte[] cipherText, String encryptionKey, String IV) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
		cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return new String(cipher.doFinal(cipherText), "UTF-8");
	}
	
	private String fillString(String text) {
		double rest = text.length() % BLOCK_SIZE;
		if(rest != 0) {
			StringBuilder builder = new StringBuilder(text);
			for (int i = 0; i < BLOCK_SIZE - rest; i++) {
				builder.append("\0");
			}
			return builder.toString();
		}
		return text;
	}
	
}
