package dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlmightyDAO extends config.DatabaseAccessor {

	/**
	 * メールアドレスを元にしたselect文.<br>
	 * ユーザーIDとパスワードのハッシュが戻って来ます.
	 *
	 * @param mailAddress
	 * @return model.User
	 */

	public ArrayList<String> selectXByYToId(String tableName,String columnName,String field) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// mysql文の用意

			String mysql = "select * from `"+tableName+"` where `"+ columnName +"` = ?";
			// DB へのコネクションを作成する
			connection = createConnection();
			// 実行するSQL文とパラメータを指定する
			preparedStatement = connection.prepareStatement(mysql);
			preparedStatement.setString(1, field);
			// SELECT 文の実行
			System.out.println("mysql    > " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			// 取得した結果を全件取得する（複数 SELECT する場合は，リストを活用する）
			ArrayList<String> results =new ArrayList<>();
			while (resultSet.next()) {
				results.add(String.valueOf(resultSet.getInt(1)));
			}

			return results;
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
