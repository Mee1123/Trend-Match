package dao.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.DatabaseAccessor;
import model.Value;

public class ValuesDAO extends DatabaseAccessor{



	public Value selectValueByName(String valueName) {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	    	//mysql文の用意
	    	String mysql = "select * form `values`(value_name) where values = ?";

	    	// DB へのコネクションを作成する
	        connection = createConnection();
	        // 実行するSQL文とパラメータを指定する
	        preparedStatement = connection.prepareStatement(mysql);
	        preparedStatement.setString(1, valueName);

	        // SELECT 文の実行
	        resultSet = preparedStatement.executeQuery();
	        preparedStatement.execute();
	        // 取得した結果を全件取得する（複数 SELECT する場合は，リストを活用する）
	        Value value = new Value();
	        while (resultSet.next()) {
	            value.setID(resultSet.getInt("value_id"));
	            value.setValue(resultSet.getString("value_name"));
	        }
	        return value;
		} catch (Exception e) {
			// TODO: handle exception
	        e.printStackTrace();
	        return null;
		}
	    finally {
	        // クローズ処理
	        close(connection, preparedStatement, resultSet);
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
