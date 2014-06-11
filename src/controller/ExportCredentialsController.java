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
		String text = generateCsv;
		PrivateKey privateKey = session.getLoggedUser().getPrivateKey();
		PublicKey publicKey = session.getLoggedUser().getPublicKey();
		
		String cryptedText = rsaEncryption.encryptWithRsaKey(privateKey, text);
		String decryptText = rsaEncryption.decryptWithRsaKey(publicKey, cryptedText);
		
		System.out.println(text);
		System.out.println(cryptedText);
		System.out.println(decryptText);
		
		result.include("credentialList", userService.getAllCredentials());
		result.forwardTo(this).exportCredentialFile();
	}
	
}
