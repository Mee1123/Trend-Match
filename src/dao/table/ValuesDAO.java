package dao.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DatabaseAccessor;
import model.Value;

public class ValuesDAO extends DatabaseAccessor{

	public Value findValue(String valueName,Connection connection) {
		try {
			String sql = "select * from `values` where value= ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, valueName);

			ResultSet resultSet = statement.executeQuery();
			resultSet.first();
			/*User user = new User();
			user.setUserId(userId);
			user.setMailAddress(resultSet.getString("mailaddress"));
			user.setPassword(resultSet.getString("password"));
			user.setName(resultSet.getString("name"));*/
			//user.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
			//user.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
			Value value = new Value();
			value.setValue(valueName);

			statement.close();
			resultSet.close();

			return value;
		} catch (SQLException e) {
			return null;
		}
	}

	public void insertValue(String value) {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	    	//mysql文の用意
	    	String mysql = "insert into `values`(value_name) values(?)";

	    	// DB へのコネクションを作成する
	        connection = createConnection();
	        // 実行するSQL文とパラメータを指定する
	        preparedStatement = connection.prepareStatement(mysql);
	        preparedStatement.setString(1, value);

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
		}
	    finally {
	        // クローズ処理
	        close(connection, preparedStatement, resultSet);
	    }
	}
}
