package dao;

import model.User;


public class Main {
	public static void main(String[] args) {
		User user = new User();
		user.setLogin("rbittencourt");
		user.setName("Robson");
		user.setPassword("12345");
		
		UserDao dao = new UserDao();
		User user2 = dao.findById(2);
		dao.delete(user2);
	}
}
