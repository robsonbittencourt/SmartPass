package dao;

import java.util.ArrayList;
import java.util.List;

import model.Credential;
import model.Password;
import model.User;


public class Main {
	public static void main(String[] args) {
		Password password = new Password();
		password.setPassword("teste");
		password.setMessageStatus("mensagem");
		
		Password password2 = new Password();
		password.setPassword("teste2");
		password.setMessageStatus("mensagem2");
		
		Credential credential = new Credential();
		credential.setLogin("sorcerer");
		credential.setPassword(password2);
		credential.setSystem("Facebook");
		
//		Credential credential2 = new Credential();
//		credential.setLogin("sorcerer2");
//		credential.setPassword(password2);
//		credential.setSystem("Twitter");
		
		
		
		User user = new User();
		user.setLogin("rbittencourt");
		user.setPassword(password);
		List<Credential> credentials = new ArrayList<Credential>();
		credentials.add(credential);
		//credentials.add(credential2);
		user.setCredentials(credentials);
		
		UserDao dao = new UserDao();
		dao.save(user);
//		User user2 = dao.findById(2);
//		dao.delete(user2);
	}
}
