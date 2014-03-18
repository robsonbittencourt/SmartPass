package fixture;

import java.util.Random;

import model.Password;


public class PasswordFixture {
	
	private Password password = new Password();
	
	public static PasswordFixture get() {
		return new PasswordFixture();
	}
	
	public Password build() {
		return this.password;
	}
	
	public PasswordFixture withWeakWeight(double weakWeight) {
		this.password.setWeakWeight(weakWeight);
		return this;
	}
	
	public PasswordFixture withMediumWeight(double mediumWeight) {
		this.password.setMediumWeight(mediumWeight);
		return this;
	}
	
	public PasswordFixture withStrongWeight(double strongWeigth) {
		this.password.setStrongWeigth(strongWeigth);
		return this;
	}

	public PasswordFixture withPassword(String password) {
		this.password.setPassword(password);
		return this;
	}
	
	public PasswordFixture withPassword() {
		this.password.setPassword(getRandomString(10));
		return this;
	}
	
	public static String getRandomString(int length) {
		final Random random = new Random();
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			switch (random.nextInt(3)) {
				case 0:
					sb.append(new Character((char) (48 + random.nextInt((57 + 1 - 48)))));
					break;
				case 1:
					sb.append(new Character((char) (97 + random.nextInt((122 + 1 - 97)))));
					break;
				case 2:
					sb.append(new Character((char) (65 + random.nextInt((90 + 1 - 65)))));
					break;
				default:
					break;
			}
		}
		return sb.toString();
	}
}
