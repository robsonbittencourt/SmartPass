package controller;

import service.ExportCredentialService;
import service.UserService;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.google.inject.Inject;

@Resource
public class ExportCredentialsController {
	
	@Inject
	private Result result;
	@Inject
	private UserService userService;
	@Inject 
	private ExportCredentialService service;
	
	@Get("/exportCredential")
	public void exportCredentialFile() {
		result.include("credentialList", userService.getAllCredentials());
	}
	
	@Post("/exportCredential/export")
	public void exportCredentialFile(String credentialsIds) {
		System.out.println(service.generateCsv(credentialsIds));
		result.include("credentialList", userService.getAllCredentials());
		result.forwardTo(this).exportCredentialFile();
	}
	
}
