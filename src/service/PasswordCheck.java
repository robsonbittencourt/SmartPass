package service;

import type.PasswordStrengthType;
import model.Password;


public interface PasswordCheck {
	
	PasswordStrengthType checkPasswordStrength(Password password);
	void setWeigth(double ponderation);
	double getWeigth();
}
