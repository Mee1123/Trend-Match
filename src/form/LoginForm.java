package form;

import java.util.ArrayList;

import config.FormConfig;
import helper.ValidationHelper;

public class LoginForm extends model.User{
	private ArrayList<String> error = new ArrayList<>();

	public LoginForm(String mailAddress,String password) {
		super();
		setMailAddress(mailAddress);
		setPassword(password);
	}

	public void MailAddressValidation(String mailAddress){
		error.add(ValidationHelper.maximumText(FormConfig.getMAX(), mailAddress, "メールアドレス"));
	}

	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}
