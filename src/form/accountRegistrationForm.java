package form;

import java.util.ArrayList;

import helper.ValidationHelper;
public class accountRegistrationForm extends model.User{
	private ArrayList<String> error = new ArrayList<String>();
	private int graduate_Int;


	public accountRegistrationForm(int jobOffer_id, String nickname,int graduate,String department,int occupation_id,int sex_id,String contact,String freeSpace,int value1,int value2, int value3) {

		setJoboffer_id(jobOffer_id);
		setNickname(nickname);
		setGraduate_Int(graduate);
		setDepartment(department);
		setOccupation_id(occupation_id);
		setSex_id(sex_id);
		setContact(contact);
		setFreespace(freeSpace);
		setValues_id(value1);
		setValues_id(value2);
		setValues_id(value3);

		nicknameValidation();//1~40
		graduateValidation();//4
		departmentValidation();//1~20
		contactValidation();//1~40
		freeSpaceValidation();//1~200

		//System.out.println(value1);

		System.out.println("Form,1,success");
	}


	public void nicknameValidation(){
		if (ValidationHelper.minimumText(1, getNickname(), "ニックネーム")!=null){
			error.add(ValidationHelper.minimumText(1, getNickname(), "ニックネーム"));
			System.out.println("ニックネームが短い");
		}
		if(ValidationHelper.maximumText(10, getNickname(), "ニックネーム")!=null){
			error.add(ValidationHelper.maximumText(10, getNickname(), "ニックネーム"));
			System.out.println("ニックネームが長い");
		}
	}

	public void graduateValidation(){
		if(ValidationHelper.maximumText(9, String.valueOf(getGraduate_Int()), "卒業年度")!=null){
			error.add(ValidationHelper.maximumText(9, String.valueOf(getGraduate_Int()), "卒業年度"));
			System.out.println("卒業年度が長い");
		}
	}

	public void departmentValidation(){
		if(ValidationHelper.maximumText(20,getDepartment(), "所属")!=null){
			error.add(ValidationHelper.maximumText(20, getDepartment(), "所属"));
			System.out.println("所属が長い");
		}
	}

	public void contactValidation(){
		if(ValidationHelper.maximumText(40,getContact(), "連絡先")!=null){
			error.add(ValidationHelper.maximumText(40, getContact(), "連絡先"));
			System.out.println("連絡先が長い");
		}
	}

	public void freeSpaceValidation(){
		if(ValidationHelper.maximumText(200,getFreespace(), "フリースペース")!=null){
			error.add(ValidationHelper.maximumText(200, getFreespace(), "フリースペース"));
			System.out.println("フリースペースが長い");
		}
	}




	public int getGraduate_Int() {
		return graduate_Int;
	}


	public void setGraduate_Int(int graduate_Int) {
		this.graduate_Int = graduate_Int;
	}


	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}