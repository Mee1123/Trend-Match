package service;

import javax.servlet.http.HttpServletRequest;

import dao.table.UsersDAO;
import form.LoginForm;
import helper.SessionHelper;
import model.User;

public class UserService {
	UsersDAO usersDAO = new UsersDAO();
	private String errorStatement = "メールアドレス、又はパスワードが違います.";

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
}
