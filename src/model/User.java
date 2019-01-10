package model;


import java.util.ArrayList;
import java.util.Date;

public class User extends Default{
	private String mailAddress;
	private String password;
	private String name;
	private String nickname;
	private String picturepath;// プロフィール画像
	private Date graduate;// 卒業年度
	private String contact;// 連絡先
	private String department;// 所属
	private String freespace;// フリースペース
	private int enneagram[];// エニアグラム
	private int occupation_id;// 職種ID
	private int sex_id;// 性別ID
	private int joboffer_id;// 内定ID
	private ArrayList<Integer> values_id;// 価値観

	public User() {
		// TODO 自動生成されたコンストラクター・スタブ
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


	public User(String nickname, String picturepath, Date graduate, String contact, String department,
			String freespace, int[] enneagram, int occupation_id, int sex_id, int jobofffer_id,
			ArrayList<Integer> values_id) {
		super();
		this.nickname = nickname;
		this.picturepath = picturepath;
		this.graduate = graduate;
		this.contact = contact;
		this.department = department;
		this.freespace = freespace;
		this.enneagram = enneagram;
		this.occupation_id = occupation_id;
		this.sex_id = sex_id;
		this.joboffer_id = jobofffer_id;
		this.values_id = values_id;
	}

	public User(String nickname, String picturepath, Date graduate, String contact, String department,
			String freespace, int enneagram_1, int enneagram_2, int enneagram_3, int enneagram_4, int enneagram_5,
			int enneagram_6, int enneagram_7, int enneagram_8, int enneagram_9, int occupation_id, int sex_id,
			int jobofffer_id, int values_1_id, int values_2_id, int values_3_id) {
		super();
		this.nickname = nickname;
		this.picturepath = picturepath;
		this.graduate = graduate;
		this.contact = contact;
		this.department = department;
		this.freespace = freespace;
		enneagram = new int[] { enneagram_1, enneagram_2, enneagram_3, enneagram_4, enneagram_5, enneagram_6,
				enneagram_7, enneagram_8, enneagram_9, };
		this.occupation_id = occupation_id;
		this.sex_id = sex_id;
		this.joboffer_id = jobofffer_id;
		this.values_id = new ArrayList<>(3);
		values_id.add(values_1_id);
		if (!values_id.contains(values_2_id)) {
			values_id.add(values_2_id);
		}
		if (!values_id.contains(values_3_id)) {
			values_id.add(values_3_id);
		}
	}

	public User(String nickname, String department, String freespace) {
		super();
		this.nickname = nickname;

		this.department = department;
		this.freespace = freespace;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPicturepath() {
		return picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
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


	public String getFreespace() {
		return freespace;
	}

	public void setFreespace(String freespace) {
		this.freespace = freespace;
	}

	public int[] getEnneagram() {
		return enneagram;
	}

	public void setEnneagram(int[] enneagram) {
		this.enneagram = enneagram;
	}

	public int getOccupation_id() {
		return occupation_id;
	}

	public void setOccupation_id(int occupation_id) {
		this.occupation_id = occupation_id;
	}

	public int getSex_id() {
		return sex_id;
	}

	public void setSex_id(int sex_id) {
		this.sex_id = sex_id;
	}

	public int getJoboffer_id() {
		return joboffer_id;
	}

	public void setJoboffer_id(int jobofffer_id) {
		this.joboffer_id = jobofffer_id;
	}

	public ArrayList<Integer> getValue_id() {
		return values_id;
	}

	public boolean setValues_id(int value_id) {
		if (values_id ==null) {
			values_id = new ArrayList<>();
		}
		if (!this.values_id.contains(value_id)) {
			if (this.values_id.size() <= 3) {
				this.values_id.add(value_id);
				return true;
			} else {
				this.values_id.remove(0);
				this.values_id.add(value_id);
				return false;
			}
		} else {
			return true;
		}
	}

	public void clearValues_id() {
		this.values_id.clear();
	}

}
