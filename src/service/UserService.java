package service;

import java.sql.Connection;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import dao.table.UsersDAO;
import form.UpdateUserInfoForm;
import helper.SessionHelper;
import model.User;

public class UserService {

	private Connection connection = null;
	private String errorStatement = "メールアドレス、又はパスワードが違います.";
	LocalDateTime dateTime = LocalDateTime.now();

	public void LoginUser(HttpServletRequest request, LoginForm form) {
		System.out.println("Service,1,success");
		User user = usersDAO.selectUserByMailAddress(form.getMailAddress());
		if (user == null) {
			form.setError(errorStatement);
			System.out.println("Service,2,success");
		} else {
			if (form.getPassword().equals(user.getPassword())) {
				SessionHelper.createUserSession(request, user.getID());
				System.out.println("Service,3,success");
			} else {
				form.setError(errorStatement);
			}
		}
	}

	public User getMyInfo(int userId) {
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		User user = new User();
		user = dao.findOne(userId, connection);
		this.connection = null;
		return user;
	}

	public void updateUserInfo(HttpServletRequest request, UpdateUserInfoForm form) {
		System.out.println("Service,1,success");
		UsersDAO dao = new UsersDAO();
		dao.update(form);
		}

}
