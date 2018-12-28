package form;

import java.util.ArrayList;

public class userRegistrationForm extends model.User{
	private ArrayList<String> error = null;

	public userRegistrationForm(String name,String email,String password,String password2) {
		//System.out.println(name);
		//System.out.println(email);
		//System.out.println(password);
		//System.out.println(password2);
		setName(name);
		setMailAddress(email);
		setPassword(password);
		setPassword(password2);
		System.out.println("Form,1,success");
	}

	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}