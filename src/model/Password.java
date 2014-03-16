package model;


public class Password {
	
	private long id;
	private String password;
	private String status;
	
	private double percentualWeak;
	private double percentualMedium;
	private double percentualStrong;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getPercentualWeak() {
		return percentualWeak;
	}

	public void setPercentualWeak(double percentualWeak) {
		this.percentualWeak = percentualWeak;
	}

	public double getPercentualMedium() {
		return percentualMedium;
	}

	public void setPercentualMedium(double percentualMedium) {
		this.percentualMedium = percentualMedium;
	}

	public double getPercentualStrong() {
		return percentualStrong;
	}
	
	public void setPercentualStrong(double percentualStrong) {
		this.percentualStrong = percentualStrong;
	}
	
}
