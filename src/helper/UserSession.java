package helper;

import model.User;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UserSession {
	
	private User loggedUser;

	public void login(User user) {
		this.loggedUser = user;
	}
  
	public boolean isLogged() {
		return loggedUser != null;
	}
	
	public void logout() {
		loggedUser = null;
	}
}
