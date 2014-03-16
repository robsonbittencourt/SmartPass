package service;

import java.util.ArrayList;

import model.Password;
import static service.PasswordStrengthType.*;


public class PasswordCheckDictionary {
	
	private ArrayList<String> dictionary = new ArrayList<String>();
	
	public PasswordCheckDictionary() {
		dictionary.add("casa");
	}
	
	public PasswordStrengthType checkPassword(Password password) {
		if(existsInDictionary(password.getPassword()))
			return WEAK;
		else {
			return STRONG;
		}
	}

	private boolean existsInDictionary(String password) {
		return dictionary.contains(password);
	}
	
	

}
