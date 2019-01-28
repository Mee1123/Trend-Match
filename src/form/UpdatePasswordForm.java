package form;

import java.util.ArrayList;

import helper.ValidationHelper;

public class UpdatePasswordForm extends model.User {
	private ArrayList<String> error = new ArrayList<>();

	public UpdatePasswordForm(String password, String password2) {
		setPassword(password);
		setPassword(password2);
		passwordValidation();
		passwordCheck(password, password2);

		System.out.println("Form,1,success");
	}

	public void passwordValidation() {
		if (ValidationHelper.minimumText(8, getPassword(), "パスワード") != null) {
			error.add(ValidationHelper.minimumText(8, getPassword(), "パスワード"));
			System.out.println("パスワードが短い");
		}
		if (ValidationHelper.maximumText(20, getPassword(), "パスワード") != null) {
			error.add(ValidationHelper.maximumText(20, getPassword(), "パスワード"));
			System.out.println("パスワードが長い");
		}

	}

	public void passwordCheck(String password, String password2) {
		if (!password.equals(password2)) {
			System.out.println("パスワード：" + password);
			System.out.println("確認用パスワード：" + password2);
			error.add("パスワードが一致しません");
			System.out.println("パスワード不一致");
		}
	}

	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}
