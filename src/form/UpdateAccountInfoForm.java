package form;

import java.sql.Date;
import java.util.ArrayList;

import helper.ValidationHelper;

public class UpdateAccountInfoForm extends model.User{
	private ArrayList<String> error = new ArrayList<>();
	private Date graduate_Int;

	public UpdateAccountInfoForm(String nickName,String picturePath,Date graduate, String department,int occupationId,int sexId,String contact,String freeSpace,
			int jobOfferId,int valueId1,int valueId2,int valueId3) {

		setNickname(nickName);
		setPicturepath(picturePath);
		setGraduate_Int(graduate);
		setDepartment(department);
		setOccupation_id(occupationId);
		setSex_id(sexId);
		setContact(contact);
		setFreespace(freeSpace);
		setJoboffer_id(jobOfferId);
		setValues_id(valueId1);
		setValues_id(valueId2);
		setValues_id(valueId3);

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
		if(ValidationHelper.maximumText(40,getFreespace(), "フリースペース")!=null){
			error.add(ValidationHelper.maximumText(40, getFreespace(), "フリースペース"));
			System.out.println("フリースペースが長い");
		}
	}

	public Date getGraduate_Int() {
		return graduate_Int;
	}

	public void setGraduate_Int(Date graduate) {
		this.graduate_Int = graduate;
	}

	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}