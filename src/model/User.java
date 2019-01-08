package model;

import javax.servlet.http.Part;

public class User extends Deflate{
	private int userId;
	private String mailAddress;
	private String password;
	private String name;
	private int eg1;
	private int eg2;
	private int eg3;
	private int eg4;
	private int eg5;
	private int eg6;
	private int eg7;
	private int eg8;
	private int eg9;

	private Part filePart;
	private int jobOffer;
	private String nickname;
	private int graduate;
	private String department;
	private int occupation;
	private int sex;
	private String contact;
	private String freeSpace;
	private String value1;
	private String value2;
	private String value3;

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

	public int getEnneagram1(){
		return eg1;
	}
	public void setEnneagram1(int eg1){
		this.eg1=eg1;
	}

	public int getEnneagram2(){
		return eg2;
	}
	public void setEnneagram2(int eg2){
		this.eg2=eg2;


	}
	public int getEnneagram3(){
		return eg3;
	}
	public void setEnneagram3(int eg3){
		this.eg3=eg3;
	}
	public int getEnneagram4(){
		return eg4;
	}
	public void setEnneagram4(int eg4){
		this.eg4=eg4;
	}

	public int getEnneagram5(){
		return eg5;
	}
	public void setEnneagram5(int eg5){
		this.eg5=eg5;
	}
	public int getEnneagram6(){
		return eg6;
	}
	public void setEnneagram6(int eg6){
		this.eg6=eg6;
	}
	public int getEnneagram7(){
		return eg7;
	}
	public void setEnneagram7(int eg7){
		this.eg7=eg7;
	}

	public int getEnneagram8(){
		return eg8;
	}
	public void setEnneagram8(int eg8){
		this.eg8=eg8;
	}

	public int getEnneagram9(){
		return eg9;
	}
	public void setEnneagram9(int eg9){
		this.eg9=eg9;
	}

	public Part getFilePart(){
		return filePart;
	}
	public void setFilePart(Part filePart){
		this.filePart=filePart;
	}

	public int getJobOffer(){
		return jobOffer;
	}
	public void setJobOffer(int jobOffer){
		this.jobOffer=jobOffer;
	}

	public String getNickname(){
		return nickname;
	}
	public void setNickname(String nickname){
		this.nickname=nickname;
	}

	public int getGraduate(){
		return graduate;
	}
	public void setGraduate(int graduate){
		this.graduate=graduate;
	}

	public String getDepartment(){
		return department;
	}
	public void setDepartment(String department){
		this.department=department;
	}

	public int getOccupation(){
		return occupation;
	}
	public void setOccupation(int occupation){
		this.occupation = occupation;
	}

	public int getSex(){
		return sex;
	}

	public void setSex(int sex){
		this.sex=sex;
	}

	public String getContact(){
		return contact;
	}
	public void setContact(String contact){
		this.contact=contact;
	}

	public String getFreeSpace(){
		return freeSpace;
	}
	public void setFreeSpace(String freeSpace){
		this.freeSpace=freeSpace;
	}
	public String getValue1(){
		return value1;
	}
	public void setValue1(String value1){
		this.value1=value1;
	}

	public String getValue2(){
		return value2;
	}
	public void setValue2(String value2){
		this.value2=value2;
	}
	public String getValue3(){
		return value3;
	}
	public void setValue3(String value3){
		this.value3=value3;
	}
}