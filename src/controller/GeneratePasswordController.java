package controller;

import service.GeneratePasswordService;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.google.inject.Inject;

@Resource
public class GeneratePasswordController {
	
	@Inject
	private Result result;
	@Inject
	private GeneratePasswordService service;
	
	@Get("/generatePassword")
	public void generatePassword() {
		
	}
	
	@Post("/generatePassword")
	public void generatePassword(int length) {
		if (isValidLength(length)) {
			String randonPassword = service.generateRandomStrongPassword(length);
			result.include("randomPassword", randonPassword);
			result.forwardTo(this).generatePassword();
		}
	}

	private boolean isValidLength(int length) {
		if (length == 0) {
			result.include("randomPassword", "Por favor, digite um tamanho para sua senha.");
			return false;
		}
		if (length < 10) {
			result.include("randomPassword", "O tamanho deve ser no mínimo 10.");
			return false;
		}
		if (length > 50) {
			result.include("randomPassword", "O tamanho deve ser no máximo 50.");
			return false;
		}
		return true;
	}
}
