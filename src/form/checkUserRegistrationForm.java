package form;

import java.util.ArrayList;

import helper.ValidationHelper;

public class checkUserRegistrationForm extends model.User{
	private ArrayList<String> error = new ArrayList<String>();

	public checkUserRegistrationForm(String name,String email,String password) {
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		setName(name);
		setMailAddress(email);
		setPassword(password);
		nameValidation();
		emailValidation();
		passwordValidation();

		System.out.println("Form,1,success");
	}

	public void nameValidation(){
		if (ValidationHelper.minimumText(1, getName(), "名前")!=null){
			error.add(ValidationHelper.minimumText(1, getName(), "名前"));
			System.out.println("名前が短い");
		}
		if(ValidationHelper.maximumText(20, getName(), "名前")!=null){
			error.add(ValidationHelper.maximumText(20, getName(), "名前"));
			System.out.println("名前が長い");
		}
	}

	public void emailValidation(){
		if (ValidationHelper.minimumText(1, getMailAddress(), "メールアドレス")!=null){
			error.add(ValidationHelper.minimumText(1, getMailAddress(), "メールアドレス"));
			System.out.println("メアドが短い");
		}
		if(ValidationHelper.maximumText(40, getMailAddress(), "メールアドレス")!=null){
			error.add(ValidationHelper.maximumText(40, getMailAddress(), "メールアドレス"));
			System.out.println("メアドが長い");
		}
		if (ValidationHelper.regularExpressionText("^.+@.+",getMailAddress(), "メールアドレス")!=null){
			error.add(ValidationHelper.regularExpressionText("^.+@.+",getMailAddress(), "メールアドレス"));
			System.out.println("メアドの形エラー");
		}
	}

	public void passwordValidation() {
		if (ValidationHelper.minimumText(8, getPassword(), "パスワード")!=null){
			error.add(ValidationHelper.minimumText(8, getPassword(), "パスワード"));
			System.out.println("パスワードが短い");
		}
		if (ValidationHelper.maximumText(20,getPassword(), "パスワード")!=null){
			error.add(ValidationHelper.maximumText(20,getPassword(), "パスワード"));
			System.out.println("パスワードが長い");
		}

	}


	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}