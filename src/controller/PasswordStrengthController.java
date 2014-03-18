package controller;

import model.Password;
import service.PasswordStrengthService;
import type.PasswordStrengthType;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.google.inject.Inject;

@Resource
public class PasswordStrengthController {

	@Inject
	private Result result;
	@Inject
	private PasswordStrengthService service;

	@Get("/passwordStrength")
	public void passwordStrength() {
		Password password = new Password();
		result.include(password);
	}

	@Post("/passwordStrength")
	public void passwordStrength(Password password) {
		PasswordStrengthType passwordStreght = service.verifyPasswordStrenght(password, null);
		password.setMessageStatus(passwordStreght.getMessageStatus());
		result.include("password", password);
	}
}
