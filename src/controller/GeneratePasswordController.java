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
	public void generate() {
		result.include("randomPassword", service.generateRandomStrongPassword());
		result.forwardTo(this).generatePassword();
	}
}
