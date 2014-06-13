package controller;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import model.PrivateKey;
import model.PublicKey;
import helper.UserSession;
import helper.WriteFile;
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
	@Inject
	private HttpServletResponse response;
	@Inject
	private WriteFile writer;
	
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
		
		result.redirectTo(this).getFile(cryptedTextWithAnotherKey);
	}
	
	public File getFile(String text) {
		return fileToDownload(writer.writeInFile(text), "credentials");
	}
	
	private File fileToDownload(File file, String fileName) {
		response.setHeader("Cache-Control", "public");
		response.setHeader("Content-Description", "File Transfer");
		response.setHeader("Content-Type", "text/txt");
		response.setHeader("Content-Disposition", String.format("attachment; filename=%s.txt", fileName));
		response.setHeader("Content-Transfer-Encoding", "binary");
		return file;
	}
	
}
