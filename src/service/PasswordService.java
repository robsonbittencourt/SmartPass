package service;

import helper.RandomHelper;

import com.google.inject.Inject;

import encryption.AES;
import model.Password;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PasswordService {
	
	@Inject
	private AES aes;
	@Inject
	private RandomHelper randomHelper;
	
	public Password getPasswordWithEncryptedKeys(String plainText) {
		Password password = new Password();
		password.setEncryptionKey(randomHelper.generateRandomString(16));
		password.setIV(randomHelper.generateRandomString(16));
		
		try {
			password.setCipherText(aes.encrypt(plainText, password.getEncryptionKey(), password.getIV()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}

}
