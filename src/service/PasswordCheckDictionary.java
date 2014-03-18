package service;

import static service.PasswordStrengthType.STRONG;
import static service.PasswordStrengthType.WEAK;

import java.util.ArrayList;

import model.Password;

public class PasswordCheckDictionary implements PasswordCheck {

	private ArrayList<String> dictionary = new ArrayList<String>();
	private double weigth = 20.0;

	public PasswordCheckDictionary() {
		dictionary.add("casa");
		dictionary.add("pão");
	}

	public PasswordStrengthType checkPasswordStrength(Password password) {
		if (existsInDictionary(password.getPassword())) 
			return WEAK;
		else {
			return STRONG;
		}
	}

	private boolean existsInDictionary(String password) {
		return dictionary.contains(password);
	}
	
	public void setWeigth(double ponderation) {
		this.weigth = ponderation;
	}

	public double getWeigth() {
		return this.weigth;
	}

}
