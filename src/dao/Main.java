package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Credential;
import model.Password;
import model.User;


public class Main {
	public static void main(String[] args) {
		Password password = new Password();
		password.setPassword("teste");
		password.setMessageStatus("mensagem");
		
		Credential credential = new Credential();
		credential.setLogin("sorcerer");
		credential.setPassword(password);
		credential.setSystem("Facebook");
		
		
		User user = new User();
		user.setLogin("rbittencourt");
		user.setPassword(password);
		List<Credential> credentials = new ArrayList<Credential>();
		credentials.add(credential);
		user.setCredentials(credentials);
		
		UserDao dao = new UserDao();
		dao.save(user);
//		User user2 = dao.findById(2);
//		dao.delete(user2);
	}
}
