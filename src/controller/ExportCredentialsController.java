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
		String csv = service.generateCsv(credentialsIds);
		csv = service.addHashOnCsv(csv);
		PrivateKey privateKey = session.getLoggedUser().getPrivateKey();
		PublicKey publicKey = session.getLoggedUser().getPublicKey();
		
		//TODO: Chaves fixas
		PublicKey publicKeyAnotherUser = new PublicKey();
		publicKeyAnotherUser.setFirst("237172541");
		publicKeyAnotherUser.setLast("16105");
		PrivateKey privateKeyAnotherUser =  new PrivateKey();
		privateKeyAnotherUser.setFirst("237172541");
		privateKeyAnotherUser.setLast("185966329");
		
		String cryptedText = rsaEncryption.encryptWithRsaKey(privateKey, csv);
		String cryptedTextWithAnotherKey = rsaEncryption.encryptWithRsaKey(publicKeyAnotherUser, cryptedText);
		
		result.include("credentialList", userService.getAllCredentials());
		result.forwardTo(this).exportCredentialFile();
	}
	
}
