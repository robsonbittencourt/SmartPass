package controller;

import java.io.File;

import service.ExportCredentialService;
import service.ImportCredentialService;

import com.google.inject.Inject;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

@Resource
public class BackupController {
	
	@Inject	
	private Result result;
	@Inject 
	private ExportCredentialService exportCredentialService;
	@Inject ImportCredentialService importCredentialService;
	
	@Get("/backup")
	public void backup() {

	}

	@Post("/backup/backupCredentials")
	public void backupCredentials() {
		result.redirectTo(this).getFile();
	}
	
	@Post("/backup/restoreCredentials")
	public void restoreCredentials(UploadedFile inputFile) {
		importCredentialService.restoreBackupFile(inputFile);
		result.forwardTo(this).backup();
	}
	
	public File getFile() {
		return exportCredentialService.backupCredentials();
	}
	
}
