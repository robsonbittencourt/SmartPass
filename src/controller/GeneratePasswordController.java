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
	public void generate(int length) {
		String randonPassword = service.generateRandomStrongPassword(length);
		if(randonPassword.isEmpty())
			randonPassword = "O tamanho deve ser no mínimo 10.";
		result.include("randomPassword", randonPassword);
		result.forwardTo(this).generatePassword();
	}
}
