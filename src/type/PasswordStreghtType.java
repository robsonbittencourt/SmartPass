package type;


public enum PasswordStreghtType {
	
	STRONG("Senha forte"),
	MEDIUM("Senha média"),
	WEAK("Senha fraca");
	
	private String messageStatus;
	
	private PasswordStreghtType(String messageStatus){
		this.messageStatus = messageStatus;
	}
	
	public String getMessageStatus() {
		return messageStatus;
	}
}
