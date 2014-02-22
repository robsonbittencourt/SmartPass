package controller;

import model.Password;
import service.StrongPasswordService;
import type.PasswordStreghtType;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.google.inject.Inject;

@Resource
public class StrongPasswordController {
	
	@Inject
	private Result result;
	@Inject
	private StrongPasswordService service;
	
	@Get("/strongPassword")
	public void strongPassword() {
		Password password = new Password();
		password.setStatus("Digite sua senha");
		result.include(password);
	}
	
	@Post("/strongPassword")
	public void strongPassword(Password password) {
		PasswordStreghtType passwordStreght = service.verifyPasswordStrenght(password.getPassword());
		password.setStatus(passwordStreght.getMessageStatus());
		result.include("password", password);
	}
}
