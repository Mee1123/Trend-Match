package service;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import dao.table.UsersDAO;
import form.LoginForm;
import form.UpdateAccountInfoForm;
import form.UpdateUserInfoForm;
import form.checkUserRegistrationForm;
import helper.HashHelper;
import helper.SessionHelper;
import model.User;

public class UserService {

	private Connection connection = null;
	private String errorStatement = "メールアドレス、又はパスワードが違います.";
	LocalDateTime dateTime = LocalDateTime.now();

	public void LoginUser(HttpServletRequest request, LoginForm form) {
		System.out.println("Service,1,success");
		UsersDAO usersDAO = new UsersDAO();
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

	public User getMyAccountInfo(int userId) {
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		User user = new User();
		user = dao.findOneAll(userId, connection);
		this.connection = null;
		return user;
	}

	public void RegistrationUser(HttpServletRequest request, checkUserRegistrationForm form) {
		//型変換の必要なし
		String name = form.getName();
		String mailAddress = form.getMailAddress();
		String password = form.getPassword();
		String hashPassword = null;
		try {
			hashPassword = HashHelper.getHash(name, password);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		UsersDAO usersDAO = new UsersDAO();
		usersDAO.insertUser(name, mailAddress, hashPassword);
	}

	public void DeleteUser(User user) {
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		dao.deleteUser(user, connection);
		this.connection = null;
	}

	public void updateUserInfo(UpdateUserInfoForm form, int userId) {
		System.out.println("Service,1,success");
		UsersDAO dao = new UsersDAO();
		dao.update(form, userId);
	}

	public void updateAccountInfo(UpdateAccountInfoForm form, int userId) {
		System.out.println("Service,1,success");
		UsersDAO dao = new UsersDAO();
		dao.updateAccount(form,userId);
	}

}
