package controller;

import service.ImportCredentialService;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

import com.google.inject.Inject;

@Resource
public class ImportCredentialsController {
	
	@Inject
	private ImportCredentialService service;

	@Get("/importCredential")
	public void importCredentialFile() {
		
	}
	
	@Post("/importCredential")
	public void importCredentialFile(UploadedFile inputFile) {
		service.importCredentialFile(inputFile);
	}
}
