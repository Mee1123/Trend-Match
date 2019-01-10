package form;

import java.sql.Date;
import java.util.ArrayList;

public class UpdateAccountInfoForm extends model.User{
	private ArrayList<String> error = new ArrayList<>();

	public UpdateAccountInfoForm(String nickName,String picturePath,Date graduate, String department,int occupationId,int sexId,String contact,String freeSpace,
			int jobOfferId,int valueId1,int valueId2,int valueId3) {
		setNickname(nickName);
		setPicturepath(picturePath);
		setGraduate(graduate);

		setDepartment(department);
		setOccupation_id(occupationId);
		setSex_id(sexId);
		setContact(contact);
		setFreespace(freeSpace);
		setJoboffer_id(jobOfferId);
		setValues_id(valueId1);
		setValues_id(valueId2);
		setValues_id(valueId3);

		System.out.println("Form,1,success");
	}

	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}