package form;

import java.util.ArrayList;

public class UpdateAccountInfoForm extends model.User{
	private ArrayList<String> error = null;

	public UpdateAccountInfoForm(String nickName,String picturePath,String department,int occupationId,int sexId,String contact,String freeSpace,
			int jobOfferId,int valueId1,int valueId2,int valueId3) {
		setNickName(nickName);
		setPicturePath(picturePath);
		setDepartment(department);
		setOccupationId(occupationId);
		setSexId(sexId);
		setContact(contact);
		setFreeSpace(freeSpace);
		setJobOfferId(jobOfferId);
		setValueId1(valueId1);
		setValueId2(valueId2);
		setValueId3(valueId3);

		System.out.println("Form,1,success");
	}

	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}