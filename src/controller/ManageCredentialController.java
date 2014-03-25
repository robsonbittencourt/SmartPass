package controller;

import model.Credential;
import model.Password;
import service.CredentialService;
import service.PasswordService;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.google.inject.Inject;

@Resource
public class ManageCredentialController {

	@Inject
	private Result result;
	@Inject
	private PasswordService passwordService;
	@Inject
	private CredentialService credentialService;
	
	@Get("/manageCredential")
	public void manageCredential() {
		result.forwardTo(this).manageCredential(new Credential());
	}
	
	@Get("/manageCredential/edit/{id}")
	public void edit(long id) {
		result.forwardTo(this).manageCredential(credentialService.findById(id));
	}
	
	@Get("/manageCredential/delete/{id}")
	public void delete(long id) {
		credentialService.delete(id);
		result.forwardTo(this).manageCredential();
	}
	
	@Post("/manageCredential/save")
	public void save(Password password) {
		passwordService.save(password);
		result.redirectTo(this).manageCredential();
	}
	
	public void manageCredential(Credential credential) {
		result.include("credential", credential);
		result.include("credentialList", credentialService.getAllCredentials());
	}

}
