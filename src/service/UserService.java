package service;

import java.util.List;

import javax.inject.Inject;

import model.Credential;
import model.User;
import dao.UserDao;


public class UserService {
	
	@Inject
	private UserDao dao;
	
	public List<Credential> getAllCredentials() {
		return dao.findById(1).getCredentials();
	}
	
	public User findById(long id) {
		return dao.findById(id);
	}

	public void save(User user) {
		dao.save(user);
	}
	
	public void update(User user) {
		dao.update(user);
	}

	public void delete(User user) {
		dao.delete(user);
	}
}
