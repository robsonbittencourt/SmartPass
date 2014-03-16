package service;

import model.Password;


public interface PasswordCheck {
	
	PasswordStrengthType checkPassword(Password password);
	
}
