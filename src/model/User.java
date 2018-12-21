package model;

public class User extends Deflate{
	private String mailAddress;
	private String password;

	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String email) {
		this.mailAddress = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
