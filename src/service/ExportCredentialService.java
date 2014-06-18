package service;

import helper.UserSession;
import helper.WriteFile;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import model.Credential;
import model.Password;
import model.PublicKey;
import br.com.caelum.vraptor.ioc.Component;

import com.google.inject.Inject;

import dao.CredentialDao;
import encryption.AES;
import encryption.MD5;
import encryption.RSAEncryption;
import encryption.TripleDES;

@Component
public class ExportCredentialService {
	
	@Inject
	private CredentialDao credentialDao;
	@Inject
	private AES aes;
	@Inject
	private MD5 md5;
	@Inject
	private RSAEncryption rsaEncryption;
	@Inject
	private UserSession session;
	@Inject
	private HttpServletResponse response;
	@Inject
	private WriteFile writer;
	@Inject
	private UserService userService;
	@Inject 
	private TripleDES tripleDES;
	
	public File exportCredentialFile(String credentialsIds, String destinyPublicKey) {
		String csv = generateCsv(credentialsIds);
		csv = addHashOnCsv(csv);
		
		PublicKey publicKeyAnotherUser = new PublicKey();
		publicKeyAnotherUser.setFirst(destinyPublicKey.substring(0, destinyPublicKey.indexOf(",")));
		publicKeyAnotherUser.setLast(destinyPublicKey.substring(destinyPublicKey.indexOf(",") + 1));
		
		String cryptedText = rsaEncryption.encryptWithRsaKey(session.getLoggedUser().getPrivateKey(), csv);
		String cryptedTextWithAnotherUserKey = rsaEncryption.encryptWithRsaKey(publicKeyAnotherUser, cryptedText);
		return getFile(cryptedTextWithAnotherUserKey, "credentials");
	}
	
	private String addHashOnCsv(String csv) {
		StringBuffer csvWithHash = new StringBuffer();
		String hash = md5.generateHash(csv);
		csvWithHash.append(csv);
		csvWithHash.append(hash);
		return csvWithHash.toString();
	}
	
	private String generateCsv(String credentialsIds) {
		StringBuffer allCredentialsCsv = new StringBuffer();
		for (String credentialId : credentialsIds.split(",")) {
			Credential credential = credentialDao.findById(Long.parseLong(credentialId));
			Password password = credential.getPassword();
			try {
				credential.getPassword().setPassword(aes.decrypt(password.getCipherText(), password.getEncryptionKey(), password.getIV()).trim());
			} catch (Exception e) {
				e.printStackTrace();
			}
			allCredentialsCsv.append(generateCsv(credential));
		}
		return allCredentialsCsv.toString();
	}
	
	private String generateCsv(Credential credential) {
		StringBuffer csv = new StringBuffer();
		csv.append(credential.getSystem());
		csv.append(";");
		csv.append(credential.getLogin());
		csv.append(";");
		csv.append(credential.getPassword().getPassword());
		csv.append("\n");
		
		return csv.toString();
	}
	
	private String generateCsv(List<Credential> credentials) {
		StringBuffer csv = new StringBuffer();
		
		for (Credential credential : credentials) {
			csv.append(generateCsv(credential));
		}
		
		return csv.toString();
	}
	
	private File getFile(String text, String fileName) {
		File teste = writer.writeInFile(text);
		return fileToDownload(teste, fileName);
	}
	
	private File fileToDownload(File file, String fileName) {
		response.setHeader("Cache-Control", "public");
		response.setHeader("Content-Description", "File Transfer");
		response.setHeader("Content-Type", "text/txt");
		response.setHeader("Content-Disposition", String.format("attachment; filename=%s.txt", fileName));
		response.setHeader("Content-Transfer-Encoding", "binary");
		return file;
	}
	
	public File backupCredentials() {
		String file = generateCsv(userService.getAllCredentials());
		try {
			file = tripleDES.encrypt(file, session.getLoggedUser().getPassword().getTripleDesKey());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getFile(file, "backup");
	}

}
