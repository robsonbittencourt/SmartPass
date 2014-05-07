package service;

import model.Password;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PasswordService {

	public Password findById(long id) {
		Password password = new Password();
		password.setId(1);
		password.setPassword("123");
		return password;
	}
	
	public void save(Password password) {
		
	}

}
