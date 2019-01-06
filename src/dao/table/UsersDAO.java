package dao.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.UpdateUserInfoForm;
import model.User;

public class UsersDAO extends config.DatabaseAccessor{

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
		}
        finally {
            // クローズ処理
            close(connection, preparedStatement, resultSet);
        }
	}

	public User findOne(int userId,Connection connection) {
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
  

	//ユーザー削除
		public void deleteUser(User user,Connection connection) {
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
			}
		    finally {
		        // クローズ処理
		        close(connection, preparedStatement, resultSet);
		    }
		}

  public void update(UpdateUserInfoForm form,int userId) {
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
		}
		finally {
            // クローズ処理
            close(connection, preparedStatement, resultSet);
        }
	}
}
