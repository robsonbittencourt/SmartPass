package controller;

import helper.RandomString;
import model.Password;
import model.User;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.google.inject.Inject;

import dao.UserDao;
import encryption.AES;

@Resource
public class NewUserController {
	
	@Inject
	private Result result;
	@Inject
	private AES aes;
	@Inject
	private RandomString randomString;
		
	@Get("/newuser")
	public void newUser() {
		Password password = new Password();
		User user = new User();
		user.setPassword(password);
		result.include("user", user);
	}
	
	@Post("/newuser")
	public void createNewUser(User user) {
		UserDao userDao = new UserDao();
		
		String password = user.getPassword().getPassword();
		user.setPassword(getPasswordWithEncryptedKeys(password));
		userDao.save(user);
		
		result.redirectTo(IndexController.class).index();
	}
	
	private Password getPasswordWithEncryptedKeys(String plainText) {
		Password password = new Password();
		
		password.setEncryptionKey(randomString.generateRandomString(16));
		password.setIV(randomString.generateRandomString(16));
		
		try {
			password.setCipherText(aes.encrypt(plainText, password.getEncryptionKey(), password.getIV()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
}
