package service;

import model.Password;


public interface PasswordCheck {
	
	PasswordStrengthType checkPasswordStrength(Password password);
	void setWeigth(double ponderation);
	double getWeigth();
}
