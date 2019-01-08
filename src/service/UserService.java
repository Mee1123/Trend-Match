package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.table.UsersDAO;
import form.AccountSearchInfoForm;
import form.LoginForm;
import helper.SessionHelper;
import model.User;

public class UserService {
	UsersDAO usersDAO = new UsersDAO();
	private String errorStatement = "メールアドレス、又はパスワードが違います.";

	public void LoginUser(HttpServletRequest request, LoginForm form) {
		User user = usersDAO.selectUserByMailAddress(form.getMailAddress());
		if (user == null) {
			form.setError(errorStatement);
		} else {
			if (form.getPassword().equals(user.getPassword())) {
				SessionHelper.createUserSession(request, user.getID());
			} else {
				form.setError(errorStatement);
			}
		}
	}

	public ArrayList<User> accountSearchInfo(HttpServletRequest request, AccountSearchInfoForm form) {
		String nickname = form.getNickname();
		String department =form.getDepartment();
		String freespace = form.getFreespace();
		String graduate=form.getGraduate_String();
		String occupation_id_String= form.getOccupation_id_String();
		String sex_id_String = form.getSex_id_String();
		String display_id_String = form.getDisplay();
		UsersDAO usersDAO = new UsersDAO();
		ArrayList<User> users = usersDAO.selectUserBySearch(nickname, department, freespace, graduate,
				occupation_id_String, sex_id_String, "", display_id_String);
		return users;
	}

	public User accountView() {
		User user = new User();
		return user;
	}

}
