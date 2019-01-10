package form;

import java.util.ArrayList;

import helper.ValidationHelper;
public class accountRegistrationCheckForm extends model.User{
	private ArrayList<String> error = new ArrayList<String>();
	private String Joboffer_id_String;// 内定ID
	private String graduate_String;// 卒業年度
	private String occupation_id_String;// 職種ID
	private String sex_id_String;// 性別ID



	public accountRegistrationCheckForm(String jobOffer, String nickname,String graduate,String department,String occupation,String sex,String contact,String freeSpace) {

		setJoboffer_id_String(jobOffer);
		setNickname(nickname);
		setGraduate_String(graduate);
		setDepartment(department);
		setOccupation_id_String(occupation);
		setSex_id_String(sex);
		setContact(contact);
		setFreespace(freeSpace);

		nicknameValidation();//1~40
		graduateValidation();//4
		departmentValidation();//1~20
		contactValidation();//1~40
		freeSpaceValidation();//1~200




		System.out.println("Form,1,success");
	}


	public void nicknameValidation(){
		if (ValidationHelper.minimumText(1, getNickname(), "ニックネーム")!=null){
			error.add(ValidationHelper.minimumText(1, getNickname(), "ニックネーム"));
			System.out.println("ニックネームが短い");
		}
		if(ValidationHelper.maximumText(40, getNickname(), "ニックネーム")!=null){
			error.add(ValidationHelper.maximumText(40, getNickname(), "ニックネーム"));
			System.out.println("ニックネームが長い");
		}
	}

	public void graduateValidation(){
		if(ValidationHelper.maximumText(9, getGraduate_String(), "卒業年度")!=null){
			error.add(ValidationHelper.maximumText(9, getGraduate_String(), "卒業年度"));
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
		if(ValidationHelper.maximumText(40,getFreespace(), "フリースペース")!=null){
			error.add(ValidationHelper.maximumText(40, getFreespace(), "フリースペース"));
			System.out.println("フリースペースが長い");
		}
	}



	public String getJoboffer_id_String() {
		return Joboffer_id_String;
	}


	public void setJoboffer_id_String(String joboffer_id_String) {
		Joboffer_id_String = joboffer_id_String;
	}


	public String getGraduate_String() {
		return graduate_String;
	}


	public void setGraduate_String(String graduate_String) {
		this.graduate_String = graduate_String;
	}


	public String getOccupation_id_String() {
		return occupation_id_String;
	}


	public void setOccupation_id_String(String occupation_id_String) {
		this.occupation_id_String = occupation_id_String;
	}


	public String getSex_id_String() {
		return sex_id_String;
	}


	public void setSex_id_String(String sex_id_String) {
		this.sex_id_String = sex_id_String;
	}


	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}