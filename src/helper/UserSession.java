package helper;

import model.User;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UserSession {
	
	private User loggedUser;

	public void login(User user) {
		this.setLoggedUser(user);
	}
  
	public boolean isLogged() {
		return getLoggedUser() != null;
	}
	
	public void logout() {
		setLoggedUser(null);
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
}
