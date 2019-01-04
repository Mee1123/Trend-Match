package form;

import java.util.ArrayList;

import helper.ValidationHelper;

public class userRegistrationForm extends model.User{
	private ArrayList<String> error = new ArrayList<String>();

	public userRegistrationForm(String name,String email,String password,String password2) {
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		System.out.println(password2);
		setName(name);
		setMailAddress(email);
		setPassword(password);
		setPassword(password2);
		nameValidation();
		emailValidation();
		passwordValidation();
		passwordCheck(password, password2);

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

	public void passwordCheck(String password,String password2){
		if(!password.equals(password2)){
			System.out.println("パスワード："+password);
			System.out.println("確認用パスワード："+password2);
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