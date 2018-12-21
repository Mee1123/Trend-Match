package form;

import java.util.ArrayList;

public class LoginForm extends model.User{
	private ArrayList<String> error = null;

	public LoginForm(String email,String password) {
		setMailAddress(email);
		setPassword(password);
		System.out.println("Form,1,success");
	}

	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}
