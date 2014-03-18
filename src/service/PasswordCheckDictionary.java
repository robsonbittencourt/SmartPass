package service;

import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;

import java.util.ArrayList;

import type.PasswordStrengthType;
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
