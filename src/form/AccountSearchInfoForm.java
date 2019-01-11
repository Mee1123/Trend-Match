package form;

import java.util.ArrayList;

import helper.ValidationHelper;
import model.User;

public class AccountSearchInfoForm extends User {

	private String graduate_String;
	private String occupation_id_String;
	private String sex_id_String;
	private String display;
	private ArrayList<String> error = new ArrayList<>();

	public AccountSearchInfoForm(String nickname, String department, String freespace, String graduate,
			String occupation_id_String, String sex_id_String, String display) {
		super(nickname, department, freespace);
		this.graduate_String = graduate;
		this.occupation_id_String = occupation_id_String;
		this.sex_id_String = sex_id_String;
		this.display = display;
		nicknameValidation();
		graduateStringValidation();
		departmentValidation();
		occupationIdStringValidation();
		sexIdStringValidation();
		freespaceValidation();
		displayValidation();

	}

	public void nicknameValidation() {
		if (ValidationHelper.minimumText(0, getNickname(), "ニックネーム") != null) {
			error.add(ValidationHelper.minimumText(0, getNickname(), "ニックネーム"));
		}
		if (ValidationHelper.maximumText(10, getNickname(), "ニックネーム") != null) {
			error.add(ValidationHelper.maximumText(10, getNickname(), "ニックネーム"));
		}
	}

	public void graduateStringValidation() {
		if (graduate_String != "") {
			if (ValidationHelper.minimumText(4, graduate_String, "卒業年度") != null) {
				error.add(ValidationHelper.minimumText(0, graduate_String, "卒業年度"));
			}
			if (ValidationHelper.maximumText(4, graduate_String, "卒業年度") != null) {
				error.add(ValidationHelper.maximumText(4, graduate_String, "卒業年度"));
			}
			if (ValidationHelper.regularExpressionText("^[1234567890]+", graduate_String, "卒業年度") != null) {
				error.add(ValidationHelper.regularExpressionText("^[1234567890]+", graduate_String, "卒業年度"));
			}
		}
	}

	public void departmentValidation() {
		if (ValidationHelper.minimumText(0, getDepartment(), "所属") != null) {
			error.add(ValidationHelper.minimumText(0, getDepartment(), "所属"));
		}
		if (ValidationHelper.maximumText(20, getDepartment(), "所属") != null) {
			error.add(ValidationHelper.maximumText(20, getDepartment(), "所属"));
		}
	}

	public void occupationIdStringValidation() {
		if (ValidationHelper.minimumText(0, occupation_id_String, "職種") != null) {
			error.add(ValidationHelper.minimumText(0, occupation_id_String, "職種"));
		}
		if (ValidationHelper.maximumText(2, occupation_id_String, "職種") != null) {
			error.add(ValidationHelper.maximumText(2, occupation_id_String, "職種"));
		}
	}

	public void sexIdStringValidation() {
		if (ValidationHelper.minimumText(0, sex_id_String, "性別") != null) {
			error.add(ValidationHelper.minimumText(0, sex_id_String, "性別"));
		}
		if (ValidationHelper.maximumText(1, sex_id_String, "性別") != null) {
			error.add(ValidationHelper.maximumText(1, sex_id_String, "性別"));
		}

	}

	public void freespaceValidation() {
		if (ValidationHelper.minimumText(0, getFreespace(), "フリースペース") != null) {
			error.add(ValidationHelper.minimumText(0, getFreespace(), "フリースペース"));
		}
		if (ValidationHelper.maximumText(20, getFreespace(), "フリースペース") != null) {
			error.add(ValidationHelper.maximumText(20, getFreespace(), "フリースペース"));
		}

	}

	public void displayValidation() {
		if (ValidationHelper.minimumText(0, display, "表示順") != null) {
			error.add(ValidationHelper.minimumText(0, display, "表示順"));
		}
		if (ValidationHelper.maximumText(20, display, "表示順") != null) {
			error.add(ValidationHelper.maximumText(20, display, "表示順"));
		}
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

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}

}
