package form;

import java.util.ArrayList;

import helper.ValidationHelper;
public class accountRegistrationCheckForm extends model.User{
	private ArrayList<String> error = new ArrayList<String>();

	public accountRegistrationCheckForm(String jobOffer, String nickname,int graduate,String department,String occupation,String sex,String contact,String freeSpace) {

		setJobOffer(jobOffer);
		setNickname(nickname);
		setGraduate(graduate);
		setDepartment(department);
		setOccupation(occupation);
		setSex(sex);
		setContact(contact);
		setFreeSpace(freeSpace);

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
		if(ValidationHelper.maximumText(9, String.valueOf(getGraduate()), "卒業年度")!=null){
			error.add(ValidationHelper.maximumText(9, String.valueOf(getGraduate()), "卒業年度"));
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
		if(ValidationHelper.maximumText(40,getFreeSpace(), "フリースペース")!=null){
			error.add(ValidationHelper.maximumText(40, getFreeSpace(), "フリースペース"));
			System.out.println("フリースペースが長い");
		}
	}



	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}