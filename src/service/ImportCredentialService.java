package service;

import helper.UserSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Credential;
import model.Password;
import model.PublicKey;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

import com.google.inject.Inject;

import encryption.MD5;
import encryption.RSAEncryption;
import encryption.TripleDES;

@Component
public class ImportCredentialService {
	
	private static final int HASH_LENGTH = 32;
	@Inject
	private RSAEncryption rsaEncryption;
	@Inject
	private UserSession session;
	@Inject 
	private UserService userService;
	@Inject
	private CredentialService credentialService;
	@Inject 
	private MD5 md5;
	@Inject
	private PasswordService passwordService;
	@Inject 
	private TripleDES tripleDES;

	public void importCredentialFile(UploadedFile inputFile, String senderPublicKey) {
		String csv = getPlainCsvFromEncryptedCredentialFile(inputFile, senderPublicKey);
		if(validateHashFromCsv(csv)) 
			importCrendentialsFromCsv(csv, true);
		 else 
			System.out.println("O arquivo a ser importado não é o mesmo arquivo que foi enviado.");

	}

	private String getPlainCsvFromEncryptedCredentialFile(UploadedFile inputFile, String senderPublicKey) {
		String cryptedText = null;
		try {
			cryptedText = new BufferedReader(new InputStreamReader(inputFile.getFile())).readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PublicKey publicKeyAnotherUser = new PublicKey(senderPublicKey);
		String decryptedText = rsaEncryption.decryptWithRsaKey(session.getLoggedUser().getPrivateKey(), cryptedText);
		String decryptedTextWithAnotherUserKey = rsaEncryption.decryptWithRsaKey(publicKeyAnotherUser, decryptedText);
		
		return decryptedTextWithAnotherUserKey;
	}
	
	private void importCrendentialsFromCsv(String csv, boolean withHash) {
		String[] csvLines = csv.split("\n");
		
		int aux = 0;
		if(withHash)
			aux++;
		
		for (int i = 0; i < csvLines.length - aux; i++) {
			String[] credentialData = csvLines[i].split(";");
			Credential credential = new Credential();
			Password password = new Password();

			credential.setSystem(credentialData[0]);
			credential.setLogin(credentialData[1]);
			password.setPassword(credentialData[2]);
			credential.setPassword(password);

			importCredential(credential);
		}
	
	}

	public boolean validateHashFromCsv(String csv) {
		String myHash = md5.generateHash(getCsvWithoutHash(csv));
		if(myHash.equals(getHashFromCsv(csv)))
			return true;
			
		return false;	
	}
	
	private String getCsvWithoutHash(String csv) {
		return csv.substring(0, csv.length() - HASH_LENGTH);
	}
	
	private String getHashFromCsv(String csv) {
		String[] csvLines = csv.split("\n");
		return csvLines[csvLines.length - 1];
	}
	
	public void importCredential(Credential credential) {
		credential.setUser(userService.findById(session.getLoggedUser().getId()));
		credential.setPassword(passwordService.getPasswordWithEncryptedKeys(credential.getPassword().getPassword()));
		credentialService.saveOrUpdate(credential);
	}
	
	public void restoreBackupFile(UploadedFile inputFile) {
		String cryptedText = null;
		try {
			cryptedText = new BufferedReader(new InputStreamReader(inputFile.getFile())).readLine();
			importCrendentialsFromCsv(tripleDES.decrypt(cryptedText, session.getLoggedUser().getPassword().getTripleDesKey()), false);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
