package controller;

import model.Credential;
import service.CredentialService;
import service.ImportCredentialService;
import service.UserService;
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
	private CredentialService credentialService;
	@Inject
	private UserService userService;
	@Inject
	private ImportCredentialService importCredentialService;
	
	@Get("/manageCredential")
	public void manageCredential() {
		result.forwardTo(this).manageCredential(new Credential());
	}
	
	@Post("/manageCredential/save")
	public void save(Credential credential) {
		importCredentialService.importCredential(credential);
		result.redirectTo(this).manageCredential();
	}
	
	@Get("/manageCredential/edit/{id}")
	public void edit(long id) {
		result.redirectTo(this).manageCredential(credentialService.findById(id));
	}
	
	@Get("/manageCredential/delete/{id}")
	public void delete(long id) {
		credentialService.delete(id);
		result.redirectTo(this).manageCredential();
	}
		
	public void manageCredential(Credential credential) {
		result.include("credential", credential);
		result.include("credentialList", userService.getAllCredentials());
	}
	
}
