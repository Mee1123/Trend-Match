package dao.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UsersDAO extends config.DatabaseAccessor{
	public User findOne(int userId,Connection connection) {
		try {
			String sql = "select * from user where user_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userId);

			ResultSet resultSet = statement.executeQuery();
			resultSet.first();
			User user = new User();
			user.setUserId(userId);
			user.setMailaddress(resultSet.getString("mailaddress"));
			user.setPassword(resultSet.getString("password"));
			//user.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
			//user.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
			statement.close();
			resultSet.close();
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

	public void update(User user,Connection connection) {
		try {
			String sql = "update user mailaddress = ? , password = ? where user_id = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUserid());
			statement.setString(2, user.getMailaddress());
			statement.setString(3, user.getPassword());
			//statement.setInt(4, bbs.getBbsId());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
