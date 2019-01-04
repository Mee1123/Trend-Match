package dao.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.DatabaseAccessor;
import model.User;

public class UsersDAO extends DatabaseAccessor{
	/**
	 * メールアドレスを元にしたselect文.<br>ユーザーIDとパスワードのハッシュが戻って来ます.
	 * @param mailAddress
	 * @return model.User
	 */

	//登録されているユーザー情報の一意性の確認
	public User selectUserByMailAddress(String mailAddress) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
			//mysql文の用意
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
		}
        finally {
            // クローズ処理
            close(connection, preparedStatement, resultSet);
        }
	}

	//ユーザー登録
	public void insertUser(String name,String mailAddress,String password) {
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
		}
	    finally {
	        // クローズ処理
	        close(connection, preparedStatement, resultSet);
	    }
	}

}
