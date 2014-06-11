package service;

import com.google.inject.Inject;

import dao.CredentialDao;
import encryption.AES;
import br.com.caelum.vraptor.ioc.Component;
import model.Credential;
import model.Password;

@Component
public class ExportCredentialService {
	
	@Inject
	private CredentialDao credentialDao;
	@Inject
	private AES aes;
	
	public String generateCsv(String credentialsIds) {
		StringBuffer allCredentialsCsv = new StringBuffer();
		for (String credentialId : credentialsIds.split(",")) {
			Credential credential = credentialDao.findById(Long.parseLong(credentialId));
			Password password = credential.getPassword();
			try {
				credential.getPassword().setPassword(aes.decrypt(password.getCipherText(), password.getEncryptionKey(), password.getIV()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			allCredentialsCsv.append(generateCsv(credential));
		}
		return allCredentialsCsv.toString();
	}
	
	public String generateCsv(Credential credential) {
		StringBuffer csv = new StringBuffer();
		csv.append(credential.getSystem());
		csv.append(";");
		csv.append(credential.getLogin());
		csv.append(";");
		csv.append(credential.getPassword().getPassword());
		csv.append("\n");
		
		return csv.toString();
	}
	
	
	
}
