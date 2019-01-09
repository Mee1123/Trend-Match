package dao.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DatabaseAccessor;
import form.UpdateUserInfoForm;
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

	//登録されているユーザーを見つける
	public User findOne(int userId,Connection connection) {
		try {
			String sql = "select * from user where user_id = ?";
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

	//アカウント(エニアグラム)登録
	@SuppressWarnings("resource")
	public void insertEnneagram(int eg1,int eg2,int eg3,int eg4,int eg5,int eg6,int eg7,int eg8,int eg9,int userID) {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	    	//mysql文の用意
	    	String mysql = "update users set enneagram_1 = ? ,enneagram_2 = ? ,enneagram_3 = ? ,enneagram_4 = ? ,enneagram_5 = ? ,enneagram_6 = ? ,enneagram_7 = ? ,enneagram_8 = ? ,enneagram_9 = ? where user_id = ?";

	    	connection = createConnection();
	    	PreparedStatement statement = connection.prepareStatement(mysql);


	    	System.out.println(mysql);


	         //resultSet.first();

	    	// DB へのコネクションを作成する
	        connection = createConnection();
	        // 実行するSQL文とパラメータを指定する
	        statement = connection.prepareStatement(mysql);
	        statement.setInt(1, eg1);
	        statement.setInt(2, eg2);
	        statement.setInt(3, eg3);
	        statement.setInt(4, eg4);
	        statement.setInt(5, eg5);
	        statement.setInt(6, eg6);
	        statement.setInt(7, eg7);
	        statement.setInt(8, eg8);
	        statement.setInt(9, eg9);
	        statement.setInt(10, userID);
	        statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
	        e.printStackTrace();
		}
	    finally {
	        // クローズ処理
	        close(connection, preparedStatement, resultSet);
	    }
	}


	//アカウント登録
		@SuppressWarnings("resource")
		public void insertAccount(int jobOffer,String nickname,int graduate,String department,int occupation,int sex,String contact,String freeSpace,int value1,int value2, int value3, int userID) {
			Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    try {
		    	//mysql文の用意
		    	String mysql = "update users set jobofffer_id = ? ,nickname = ? ,graduate = ? ,department = ? ,occupation_id = ? ,sex_id = ? ,contact = ? ,freespace = ? ,value_1_id= ? ,value_2_id = ? ,value_3_id= ? where user_id = ?";

		    	connection = createConnection();
		    	PreparedStatement statement = connection.prepareStatement(mysql);


		    	System.out.println(mysql);


		         //resultSet.first();

		    	// DB へのコネクションを作成する
		        connection = createConnection();
		        // 実行するSQL文とパラメータを指定する
		        statement = connection.prepareStatement(mysql);
		        //statement.setInt(1, filePart);
		        statement.setInt(1, jobOffer);
		        statement.setString(2, nickname);
		        statement.setInt(3,graduate );
		        statement.setString(4, department);
		        statement.setInt(5, occupation);
		        statement.setInt(6, sex);
		        statement.setString(7, contact);
		        statement.setString(8, freeSpace);
		        statement.setInt(9, value1);
		        statement.setInt(10, value2);
		        statement.setInt(11, value3);
		        statement.setInt(12, userID);
		        statement.executeUpdate();

			} catch (Exception e) {
				// TODO: handle exception
		        e.printStackTrace();
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
