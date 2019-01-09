package service;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import dao.table.UsersDAO;
import form.LoginForm;
import form.UpdateUserInfoForm;
import form.checkUserRegistrationForm;
import helper.HashHelper;
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

	public User getMyInfo(int userId) {
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		User user = new User();
		user = dao.findOne(userId, connection);
		this.connection = null;
		return user;
	}

	public void updateUserInfo(UpdateUserInfoForm form,int userId) {
		System.out.println("Service,1,success");
		UsersDAO dao = new UsersDAO();
		dao.update(form,userId);
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

		usersDAO.insertUser(name, mailAddress, hashPassword);
	}

  	public void DeleteUser(User user) {
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		dao.deleteUser(user, connection);
		this.connection = null;
	}
}
