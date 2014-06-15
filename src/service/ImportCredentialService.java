package service;

import helper.UserSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.inject.Inject;

import encryption.RSAEncryption;
import model.PublicKey;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ImportCredentialService {
	
	@Inject
	private RSAEncryption rsaEncryption;
	@Inject
	private UserSession session;
	

	public void importCredentialFile(UploadedFile inputFile, String senderPublicKey) {
		String cryptedText = null;
		try {
			cryptedText = new BufferedReader(new InputStreamReader(inputFile.getFile())).readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PublicKey publicKeyAnotherUser = new PublicKey(senderPublicKey);
		String decryptedText = rsaEncryption.decryptWithRsaKey(session.getLoggedUser().getPrivateKey(), cryptedText);
		String decryptedTextWithAnotherUserKey = rsaEncryption.decryptWithRsaKey(publicKeyAnotherUser, decryptedText);
		
		System.out.println(decryptedTextWithAnotherUserKey);
	}

}
