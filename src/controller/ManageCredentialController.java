package controller;

import helper.RandomHelper;
import helper.UserSession;
import model.Credential;
import model.Password;
import service.CredentialService;
import service.UserService;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.google.inject.Inject;

import encryption.AES;

@Resource
public class ManageCredentialController {

	@Inject
	private Result result;
	@Inject
	private CredentialService credentialService;
	@Inject
	private UserService userService;
	@Inject
	private AES aes;
	@Inject
	private RandomHelper randomHelper;
	@Inject
	private UserSession session;
	
	
	@Get("/manageCredential")
	public void manageCredential() {
		result.forwardTo(this).manageCredential(new Credential());
	}
	
	@Post("/manageCredential/save")
	public void save(Credential credential) {
		credential.setUser(userService.findById(session.getLoggedUser().getId()));
		credential.setPassword(getPasswordWithEncryptedKeys(credential.getPassword().getPassword()));
		credentialService.saveOrUpdate(credential);
		
		result.redirectTo(this).manageCredential();
	}
	
	@Get("/manageCredential/edit/{id}")
	public void edit(long id) {
		Credential credential = credentialService.findById(id);
		credential.setPassword(getPasswordWithEncryptedKeys(credential.getPassword().getPassword()));
		result.redirectTo(this).manageCredential(credential);
	}
	
	@Get("/manageCredential/delete/{id}")
	public void delete(long id) {
		Credential credential = credentialService.findById(id);
		credentialService.delete(credential);
		result.redirectTo(this).manageCredential();
	}
		
	public void manageCredential(Credential credential) {
		result.include("credential", credential);
		result.include("credentialList", userService.getAllCredentials());
	}
	
	private Password getPasswordWithEncryptedKeys(String plainText) {
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
