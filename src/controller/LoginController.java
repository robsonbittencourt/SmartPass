package controller;

import helper.Inrestrict;
import helper.UserSession;

import com.google.inject.Inject;

import dao.UserDao;
import encryption.CaesarCipher;
import model.Password;
import model.User;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class LoginController {
	
	@Inject
	private Result result;
	@Inject
	private Validator validator;
	@Inject
	private UserSession session;
	@Inject
	private CaesarCipher caesarCipher;

	
	@Get("/")
	@Inrestrict
	public void login() {
		Password password = new Password();
		User user = new User();
		user.setPassword(password);
		result.include("user", user);
	}
	
	@Post("/login")
	@Inrestrict
	public void doLogin(User user) {
		UserDao userDao = new UserDao();
		User baseUser = userDao.findByLogin(user.getLogin());
		
		if(baseUser != null) {
			int caesarNumber = baseUser.getPassword().getCaesarNumber();
			String encryptionKey = baseUser.getPassword().getCaesarEncrypted();
			
			boolean correctPassword = caesarCipher.decrypt(caesarNumber, encryptionKey).equals(user.getPassword().getPassword());
			
			if(!correctPassword) {
				validator.add(new ValidationMessage("Login e/ou senha inválidos", "usuario.login"));	
			}
		} else {
			validator.add(new ValidationMessage("Login e/ou senha inválidos", "usuario.login"));
		}
		
		validator.onErrorUsePageOf(LoginController.class).login();
		
		session.login(baseUser);
	    result.redirectTo(IndexController.class).index();
	}
	
	@Get("/logout")
	public void logout() {
		session.logout();
		result.redirectTo(LoginController.class).login();;
	}
}
