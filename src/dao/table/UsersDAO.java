package dao.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.UpdateAccountInfoForm;
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
			user.setMailAddress(resultSet.getString("mailAddress"));
			user.setPassword(resultSet.getString("password"));
			user.setName(resultSet.getString("name"));
			user.setNickName(resultSet.getString("nickName"));
			user.setPicturePath(resultSet.getString("picturePath"));
			user.setGraduate(Integer.parseInt(resultSet.getString("graduate")));
			user.setContact("contact");
			user.setDepartment("department");
			user.setOccupationId(Integer.parseInt(resultSet.getString("occupationId")));
			user.setSexId(Integer.parseInt(resultSet.getString("sexId")));
			user.setJobOfferId(Integer.parseInt(resultSet.getString("jobOfferId")));
			user.setFreeSpace("freeSpace");
			user.setValueId1(Integer.parseInt(resultSet.getString("valueId1")));
			user.setValueId2(Integer.parseInt(resultSet.getString("valueId2")));
			user.setValueId3(Integer.parseInt(resultSet.getString("valueId3")));

			//user.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
			//user.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
			statement.close();
			resultSet.close();
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

	public void updateAccount(UpdateAccountInfoForm form) {
		System.out.println("DAO,1,success");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
		try {
			String sql = "update user mailaddress = ? , password = ? , name = ? , where user_id = ? ";
			System.out.println("DAO,2,success");
            connection = createConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, form.getNickName());
			statement.setString(2, form.getPicturePath());
			statement.setInt(3, form.getGraduate());
			statement.setString(4, form.getContact());
			statement.setString(5, form.getDepartment());
			statement.setInt(6, form.getOccupationId());
			statement.setInt(7, form.getSexId());
			statement.setInt(8, form.getJobOfferId());
			statement.setString(9,form.getFreeSpace());
			statement.setInt(10, form.getValueId1());
			statement.setInt(11, form.getValueId2());
			statement.setInt(12, form.getValueId3());

			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
            // クローズ処理
            close(connection, preparedStatement, resultSet);
        }
	}
}
