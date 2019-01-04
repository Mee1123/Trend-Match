package dao.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.UpdateAccountInfoForm;
import form.UpdateUserInfoForm;
import model.User;

public class UsersDAO extends config.DatabaseAccessor {

	/**
	 * メールアドレスを元にしたselect文.<br>ユーザーIDとパスワードのハッシュが戻って来ます.
	 * @param mailAddress
	 * @return model.User
	 */

	public User selectUserByMailAddress(String mailAddress) {
		System.out.println("DAO,1,success");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//mysql文の用意

			String mysql = "select * form users where mailaddress = ?";
			// DB へのコネクションを作成する
			System.out.println("DAO,2,success");

			connection = createConnection();
			// 実行するSQL文とパラメータを指定する
			preparedStatement = connection.prepareStatement(mysql);
			preparedStatement.setString(1, mailAddress);
			// SELECT 文の実行
			resultSet = preparedStatement.executeQuery();
			// 取得した結果を全件取得する（複数 SELECT する場合は，リストを活用する）
			User user = new User();

			System.out.println("DAO,3,success");
			while (resultSet.next()) {
				user.setID(resultSet.getInt("user_id"));
				user.setPassword(resultSet.getString("password"));
			}
			System.out.println("DAO,4,success");

			return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			// クローズ処理
			close(connection, preparedStatement, resultSet);
		}
	}

	public User findOne(int userId, Connection connection) {
		try {
			String sql = "select * from users where user_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userId);

			ResultSet resultSet = statement.executeQuery();
			resultSet.first();

			User user = new User();
			user.setUserId(userId);
			user.setMailAddress(resultSet.getString("mailaddress"));
			user.setPassword(resultSet.getString("password"));
			user.setName(resultSet.getString("name"));
			//user.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
			//user.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
			statement.close();
			resultSet.close();
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

	//ユーザー登録
	public void insertUser(String name, String mailAddress, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//mysql文の用意
			String mysql = "insert into users(name,mailaddress,password) values(?,?,?)";

			// DB へのコネクションを作成する
			connection = createConnection();
			// 実行するSQL文とパラメータを指定する
			preparedStatement = connection.prepareStatement(mysql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, mailAddress);
			preparedStatement.setString(3, password);

			// SELECT 文の実行
			//resultSet = preparedStatement.executeQuery();
			preparedStatement.execute();
			// 取得した結果を全件取得する（複数 SELECT する場合は，リストを活用する）
			/*User user = new User();
			while (resultSet.next()) {
			    user.setID(resultSet.getInt("user_id"));
			    user.setPassword(resultSet.getString("password"));
			}

			return True;
			*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//return null;
		} finally {
			// クローズ処理
			close(connection, preparedStatement, resultSet);
		}
	}

	//ユーザー削除
	public void deleteUser(User user, Connection connection) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "delete from users where user_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, user.getUserId());
			statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//return null;
		} finally {
			// クローズ処理
			close(connection, preparedStatement, resultSet);
		}
	}

	public void update(UpdateUserInfoForm form, int userId) {
		System.out.println("DAO,1,success");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "update users set mailaddress = ? , password = ? , name = ? where user_id = ? ";
			System.out.println("DAO,2,success");
			connection = createConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, form.getMailAddress());
			statement.setString(2, form.getPassword());
			statement.setString(3, form.getName());
			statement.setInt(4, userId);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// クローズ処理
			close(connection, preparedStatement, resultSet);
		}
	}

	public User findOneAll(int userId, Connection connection) {
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
			statement.setString(9, form.getFreeSpace());
			statement.setInt(10, form.getValueId1());
			statement.setInt(11, form.getValueId2());
			statement.setInt(12, form.getValueId3());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// クローズ処理
			close(connection, preparedStatement, resultSet);
		}
	}
}
