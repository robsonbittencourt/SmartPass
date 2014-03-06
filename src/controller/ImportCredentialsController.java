package controller;

import service.ImportCredentialsService;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

import com.google.inject.Inject;

@Resource
public class ImportCredentialsController {
	
	@Inject
	private ImportCredentialsService service;

	@Get("/importCredentials")
	public void importCredentialsFile() {
		
	}
	
	@Post("/importCredentials")
	public void importCredentialsFile(UploadedFile inputFile) {
		service.importCredentialsFile(inputFile);
	}
}
