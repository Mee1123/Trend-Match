package form;

import java.util.ArrayList;

public class UpdateUserInfoForm extends model.User {

	private ArrayList<String> error = new ArrayList<String>();

	public UpdateUserInfoForm(String email, String password, String name) {
		setMailAddress(email);
		setPassword(password);
		setName(name);
		System.out.println("Form,1,success");
	}

	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}
