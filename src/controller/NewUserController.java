package controller;

import helper.Inrestrict;

import java.util.Random;

import model.Password;
import model.User;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

import com.google.inject.Inject;

import dao.UserDao;
import encryption.CaesarCipher;
import encryption.RSAKeysGenerator;

@Resource
public class NewUserController {
	
	@Inject
	private Result result;
	@Inject
	private Validator validator;
	@Inject
	private CaesarCipher caesarCipher;
	@Inject
	RSAKeysGenerator rsaEncription;
		
	@Get("/newuser")
	@Inrestrict
	public void newUser() {
		Password password = new Password();
		User user = new User();
		user.setPassword(password);
		result.include("user", user);
	}
	
	@Post("/newuser")
	@Inrestrict
	public void createNewUser(User user) {
		UserDao userDao = new UserDao();
		if(userDao.findByLogin(user.getLogin()) != null) {
			validator.add(new ValidationMessage("Login ja existe", "usuario.login"));
		}
		validator.onErrorUsePageOf(NewUserController.class).newUser();

		Random random = new Random();
		int randomNumber = random.nextInt(26);
		
		String password = user.getPassword().getPassword();
		user.getPassword().setCaesarNumber(randomNumber);
		
		String caesarEncrypted = caesarCipher.encrypt(randomNumber, password);
		user.getPassword().setCaesarEncrypted(caesarEncrypted);
		
		user.setRsaKeys(rsaEncription.createKeys());
		
		userDao.save(user);
		
		result.include("message", "Usuario criado com sucesso. Realize seu login.");
		result.redirectTo(LoginController.class).login();
	}
	
	
}
