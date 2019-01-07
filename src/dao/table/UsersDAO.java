package dao.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DatabaseAccessor;
import model.User;

public class UsersDAO extends DatabaseAccessor {
	/**
	 * メールアドレスを元にしたselect文.<br>
	 * ユーザーIDとパスワードのハッシュが戻って来ます.
	 *
	 * @param mailAddress
	 * @return model.User
	 */
	public User selectUserByMailAddress(String mailAddress) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// mysql文の用意
			String mysql = "select * from users where mailaddress = ?";
			// DB へのコネクションを作成する
			connection = createConnection();
			// 実行するSQL文とパラメータを指定する
			preparedStatement = connection.prepareStatement(mysql);
			preparedStatement.setString(1, mailAddress);
			// SELECT 文の実行
			resultSet = preparedStatement.executeQuery();
			// 取得した結果を全件取得する（複数 SELECT する場合は，リストを活用する）
			User user = new User();
			while (resultSet.next()) {
				user.setID(resultSet.getInt("user_id"));
				user.setPassword(resultSet.getString("password"));
			}
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

	public ArrayList<User> selectUserBySearch(String nickname, String department, String freespace, String graduate,
			String occupation_id_String, String sex_id_String, String jobofffer_id_String, String display) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// mysql文の用意
			String mysql = "select * from users ";
			// DB へのコネクションを作成する
			connection = createConnection();
			// 実行するSQL文とパラメータを指定する
			int parameterCount = 0;
			if (!nickname.equals("") || !department.equals("") || !freespace.equals("") || !graduate.equals("")
					|| !occupation_id_String.equals("") || !sex_id_String.equals("")
					|| !jobofffer_id_String.equals("")) {
				mysql += "where ";
				parameterCount++;
			}
			if (!nickname.equals("")) {
				parameterCount++;
				if (parameterCount != 2) {
					mysql = mysql + " and ";
				}
				mysql = mysql + "nickname = '" + nickname + "' ";
			}
			if (!department.equals("")) {
				parameterCount++;
				if (parameterCount != 2) {
					mysql = mysql + " and ";
				}
				mysql = mysql + "department = '" + department + "' ";
			}
			if (!freespace.equals("")) {
				parameterCount++;
				if (parameterCount != 2) {
					mysql = mysql + " and ";
				}
				mysql = mysql + "freespace = '" + freespace + "' ";
			}
			if (!graduate.equals("")) {
				parameterCount++;
				if (parameterCount != 2) {
					mysql = mysql + " and ";
				}
				mysql = mysql + "graduate = '" + graduate + "' ";
			}
			if (!occupation_id_String.equals("")) {
				parameterCount++;
				if (parameterCount != 2) {
					mysql = mysql + " and ";
				}
				mysql = mysql + "occupation_id = " + occupation_id_String + " ";
			}
			if (!sex_id_String.equals("")) {
				parameterCount++;
				if (parameterCount != 2) {
					mysql = mysql + " and ";
				}
				mysql = mysql + "sex_id = " + sex_id_String + " ";
			}
			if (!jobofffer_id_String.equals("")) {
				parameterCount++;
				if (parameterCount != 2) {
					mysql = mysql + " and ";
				}
				mysql = mysql + "jobofffer_id = " + jobofffer_id_String + " ";
			}
			if (display.equals("number")) {
				mysql = mysql + "order by user_id";
			}
			preparedStatement = connection.prepareStatement(mysql);
			// SELECT 文の実行
			System.out.println("mysql    > " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			// 取得した結果を全件取得する（複数 SELECT する場合は，リストを活用する）
			ArrayList<User> users = new ArrayList<>();
			while (resultSet.next()) {
				User user = new User();
				user.setID(resultSet.getInt("user_id"));
				user.setNickname(resultSet.getString("nickname"));
				user.setGraduate(resultSet.getDate("graduate"));
				user.setContact(resultSet.getString("contact"));
				user.setFreespace(resultSet.getString("freespace"));
				int enneagram[] = new int[9];// エニアグラム
				enneagram[0] = resultSet.getInt("enneagram_1");
				enneagram[1] = resultSet.getInt("enneagram_2");
				enneagram[2] = resultSet.getInt("enneagram_3");
				enneagram[3] = resultSet.getInt("enneagram_4");
				enneagram[4] = resultSet.getInt("enneagram_5");
				enneagram[5] = resultSet.getInt("enneagram_6");
				enneagram[6] = resultSet.getInt("enneagram_7");
				enneagram[7] = resultSet.getInt("enneagram_8");
				enneagram[8] = resultSet.getInt("enneagram_9");
				user.setEnneagram(enneagram);
				user.setSex_id(resultSet.getInt("sex_id"));
				user.setJobofffer_id(resultSet.getInt("jobofffer_id"));
				user.setValues_id(resultSet.getInt("value_1_id"));
				user.setValues_id(resultSet.getInt("value_2_id"));
				user.setValues_id(resultSet.getInt("value_3_id"));
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			// クローズ処理
			close(connection, preparedStatement, resultSet);
		}
	}

}
