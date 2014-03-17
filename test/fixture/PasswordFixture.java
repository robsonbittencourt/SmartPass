package fixture;

import model.Password;


public class PasswordFixture {
	
	private Password password = new Password();
	
	public static PasswordFixture get() {
		return new PasswordFixture();
	}
	
	public Password build() {
		return this.password;
	}
	
	public PasswordFixture withPercentualWeak(double percentualWeak) {
		this.password.setPercentualWeak(percentualWeak);
		return this;
	}
	
	public PasswordFixture withPercentualMedium(double percentualMedium) {
		this.password.setPercentualMedium(percentualMedium);
		return this;
	}
	
	public PasswordFixture withPercentualStrong(double percentualStrong) {
		this.password.setPercentualStrong(percentualStrong);
		return this;
	}

	public PasswordFixture withPassword() {
		this.password.setPassword("123");
		return this;
	}

	public PasswordFixture withPassword(String password) {
		this.password.setPassword(password);
		return this;
	}
}
