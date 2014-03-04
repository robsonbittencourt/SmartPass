package controller;

import model.Password;
import service.PasswordService;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.google.inject.Inject;

@Resource
public class ManagePasswordController {

	@Inject
	private Result result;
	@Inject
	private PasswordService passwordService;
	@Inject
	private CredentialService credentialService;
	
	@Get("/managePassword")
	public void managePassword() {
		result.forwardTo(this).form(new Password());
	}
	
	@Get("/managePassword/edit/{id}")
	public void edit(long id) {
		result.forwardTo(this).form(passwordService.findById(id));
	}
	
	@Get("/managePassword/delete/{id}")
	public void delete(long id) {
		credentialService.delete(id);
		result.forwardTo(this).managePassword();
	}
	
	@Post("/managePassword/save")
	public void save(Password password) {
		passwordService.save(password);
		result.redirectTo(this).managePassword();
	}
	
	public void form(Password password) {
		result.include("password", password);
		result.include("credentialList", credentialService.getAllCredentials());
	}

}
