package controller;

import helper.Inrestrict;

import java.util.List;
import java.util.Random;

import model.Password;
import model.PrivateKey;
import model.PublicKey;
import model.User;
import service.UserService;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

import com.google.inject.Inject;

import encryption.CaesarCipher;
import encryption.RSAKeysGenerator;
import encryption.RSAKey;

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
	@Inject
	private UserService userService;
		
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
		if(userService.findByLogin(user.getLogin()) != null) {
			validator.add(new ValidationMessage("Login ja existe", "usuario.login"));
		}
		validator.onErrorUsePageOf(NewUserController.class).newUser();

		Random random = new Random();
		int randomNumber = random.nextInt(26);
		
		String password = user.getPassword().getPassword();
		user.getPassword().setCaesarNumber(randomNumber);
		
		String caesarEncrypted = caesarCipher.encrypt(randomNumber, password);
		user.getPassword().setCaesarEncrypted(caesarEncrypted);
		
		List<RSAKey> keys = rsaEncription.createKeys();
		user.setPublicKey((PublicKey)keys.get(0));
		user.setPrivateKey((PrivateKey)keys.get(1));
		
		userService.save(user);
		
		result.include("message", "Usuario criado com sucesso. Realize seu login.");
		result.redirectTo(LoginController.class).login();
	}
	
}
