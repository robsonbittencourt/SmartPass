package service;

import java.util.ArrayList;
import java.util.List;

import model.Credential;
import model.Password;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class CredentialService {
	
	public Credential findById(long id) {
		Credential credential = new Credential();
		Password password = new Password();
		password.setPassword("123");
		
		credential.setId(1);
		credential.setPassword(password);
		credential.setSystem("Facebook");
		credential.setUser("Peter");
		return credential;
	}

	public List<Credential> getAllCredentials() {
		Password password1 = new Password();
		password1.setPassword("1234");
		
		Password password2 = new Password();
		password2.setPassword("123");
		
		Password password3 = new Password();
		password3.setPassword("12345");
		
		Credential credential1 = new Credential();
		credential1.setId(1);
		credential1.setSystem("Facebook");
		credential1.setUser("Mike");
		credential1.setPassword(password1);
		
		Credential credential2 = new Credential();
		credential2.setId(2);
		credential2.setSystem("Twitter");
		credential2.setUser("Peter");
		credential2.setPassword(password2);
		
		Credential credential3 = new Credential();
		credential3.setId(3);
		credential3.setSystem("Google+");
		credential3.setUser("Sandra");
		credential3.setPassword(password3);
		
		List<Credential> credentials = new ArrayList<Credential>();
		
		credentials.add(credential1);
		credentials.add(credential2);
		credentials.add(credential3);
		return credentials;
	}

	public void delete(long id) {
		
	}

}
