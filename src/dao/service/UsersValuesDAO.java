package dao.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import helper.DateHelper;
import model.User;

public class UsersValuesDAO extends config.DatabaseAccessor {
	/**
	 * idとエニアグラムの入ったデータを返します.
	 *
	 * @param type
	 *            :学生ならtrue,社会人ならfalse
	 * @return
	 */
	public ArrayList<User> selectEnneagramByUserType(boolean type) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// mysql文の用意
			String judge = (type) ? " > ?" : " < ?";
			String mysql = "select * from users where enneagram_1 is not null and graduate "
					+ judge;
			// DB へのコネクションを作成する
			connection = createConnection();
			// 実行するSQL文とパラメータを指定する
			preparedStatement = connection.prepareStatement(mysql);
			java.util.Date date = new java.util.Date();
			Date data = DateHelper.toSqlDate(date);
			String data1 = data.toString();
			System.out.println(data1);
			preparedStatement.setDate(1, data);
			// SELECT 文の実行
			resultSet = preparedStatement.executeQuery();
			// 取得した結果を全件取得する（複数 SELECT する場合は，リストを活用する）
			ArrayList<User> users = new ArrayList<>();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("user_id"));
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
				user.setValues_id(resultSet.getInt("value_1_id"));
				user.setValues_id(resultSet.getInt("value_2_id"));
				user.setValues_id(resultSet.getInt("value_3_id"));
				user.setEnneagram(enneagram);
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
