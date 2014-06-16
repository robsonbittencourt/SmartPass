package service;

import helper.UserSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import model.Credential;
import model.Password;
import model.User;
import dao.UserDao;
import encryption.AES;


public class UserService {
	
	@Inject
	private UserDao dao;
	@Inject
	private AES aes;
	@Inject
	private UserSession session;
	
	public List<Credential> getAllCredentials() {
		User user = dao.findById(session.getLoggedUser().getId());
		if(user != null) {
			List<Credential> credentials = user.getCredentials();
			for (Credential credential : credentials) {
				Password password = credential.getPassword();
				try {
					credential.getPassword().setPassword(aes.decrypt(password.getCipherText(), password.getEncryptionKey(), password.getIV()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return user.getCredentials();
		}	
			
		return new ArrayList<Credential>();
	}
	
	public User findById(long id) {
		return dao.findById(id);
	}
	
	public User findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public void save(User user) {
		dao.save(user);
	}

}
