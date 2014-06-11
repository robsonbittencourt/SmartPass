package controller;

import model.PrivateKey;
import model.PublicKey;
import helper.UserSession;
import service.ExportCredentialService;
import service.UserService;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.google.inject.Inject;

import encryption.RSAEncryption;

@Resource
public class ExportCredentialsController {
	
	@Inject	
	private Result result;
	@Inject
	private UserService userService;
	@Inject 
	private ExportCredentialService service;
	@Inject
	private RSAEncryption rsaEncryption;
	@Inject
	private UserSession session;
	
	@Get("/exportCredential")
	public void exportCredentialFile() {
		result.include("credentialList", userService.getAllCredentials());
	}
	
	@Post("/exportCredential/export")
	public void exportCredentialFile(String credentialsIds) {
		String generateCsv = service.generateCsv(credentialsIds);
		String text = "123";
		PrivateKey privateKey = session.getLoggedUser().getPrivateKey();
		PublicKey publicKey = session.getLoggedUser().getPublicKey();
		
		//TODO: Chaves fixa
		PublicKey publicKeyAnotherUser = new PublicKey();
		publicKeyAnotherUser.setFirst("143");
		publicKeyAnotherUser.setLast("7");
		PrivateKey privateKeyAnotherUser =  new PrivateKey();
		privateKeyAnotherUser.setFirst("143");
		privateKeyAnotherUser.setLast("103");
		
		String cryptedText1 = rsaEncryption.encryptWithRsaKey(privateKey, text);
		String cryptedText = rsaEncryption.encryptWithRsaKey(publicKeyAnotherUser, cryptedText1);
		String decryptedText = rsaEncryption.decryptWithRsaKey(privateKeyAnotherUser, cryptedText);
		String decryptedText1 = rsaEncryption.decryptWithRsaKey(publicKey, decryptedText);
		
		System.out.println(text);
		System.out.println(cryptedText1);
		System.out.println(decryptedText);
		System.out.println(decryptedText1);
		
		result.include("credentialList", userService.getAllCredentials());
		result.forwardTo(this).exportCredentialFile();
	}
	
}
