package type;


public enum PasswordStrengthType {
	
	STRONG("Senha forte"),
	MEDIUM("Senha média"),
	WEAK("Senha fraca");
	
	private String messageStatus;
	
	private PasswordStrengthType(String messageStatus){
		this.messageStatus = messageStatus;
	}
	
	public String getMessageStatus() {
		return messageStatus;
	}
}
