package service;

import dao.table.UsersDAO;
import model.User;

public class UserService {

	public User getMyInfo(int userId) {
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		User user = new User();
		user = dao.findOne(userId, connection);
		this.connection = null;
		return user;
	}

	public void updateUserInfo(User user) {
		user.setUpdatedAt(dateTime);
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		dao.update(user, connection);
		this.connection = null;
	}
}
