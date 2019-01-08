
package model;

import java.sql.Date;

public class User extends Deflate {
	private int userId;
	private String mailAddress;
	private String password;
	private String name;
	private String nickName;
	private String picturePath;
	private Date graduate;
	private String contact;
	private String department;
	private int occupationId;
	private int sexId;
	private int jobOfferId;
	private String freeSpace;
	private int valueId1;
	private int valueId2;
	private int valueId3;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String email) {
		this.mailAddress = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public Date getGraduate() {
		return graduate;
	}

	public void setGraduate(Date graduate) {
		this.graduate = graduate;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(int occupationId) {
		this.occupationId = occupationId;
	}

	public int getSexId() {
		return sexId;
	}

	public void setSexId(int sexId) {
		this.sexId = sexId;
	}

	public int getJobOfferId() {
		return jobOfferId;
	}

	public void setJobOfferId(int jobOfferId) {
		this.jobOfferId = jobOfferId;
	}

	public String getFreeSpace() {
		return freeSpace;
	}

	public void setFreeSpace(String freeSpace) {
		this.freeSpace = freeSpace;
	}

	public int getValueId1() {
		return valueId1;
	}

	public void setValueId1(int valueId1) {
		this.valueId1 = valueId1;
	}

	public int getValueId2() {
		return valueId2;
	}

	public void setValueId2(int valueId2) {
		this.valueId2 = valueId2;
	}

	public int getValueId3() {
		return valueId3;
	}

	public void setValueId3(int valueId3) {
		this.valueId3 = valueId3;
	}
}
