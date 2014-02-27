package controller;

import java.util.ArrayList;
import java.util.List;

import model.Password;
import service.ManagePasswordService;
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
	private ManagePasswordService service;

	@Get("/managePassword")
	public void managePassword() {
		result.include("password", new Password());
		result.include("passwordList", service.getAllPasswords());
	}
	
	@Post("/managePassword/save")
	public void save(Password password) {
		service.save(password);
		result.redirectTo(this).managePassword();
	}

}
