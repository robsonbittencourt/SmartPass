package service;

import model.Password;


public interface PasswordCheck {
	
	PasswordStrengthType checkPasswordStrength(Password password);
	void setPonderation(double ponderation);
	double getPonderation();
}
