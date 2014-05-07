package dao;

import model.Password;
import model.User;


public class Main {
	public static void main(String[] args) {
		Password password = new Password();
		password.setPassword("teste");
		
		User user = new User();
		user.setLogin("rbittencourt");
		user.setPassword(password);
		
		UserDao dao = new UserDao();
		dao.save(user);
//		User user2 = dao.findById(2);
//		dao.delete(user2);
	}
}
