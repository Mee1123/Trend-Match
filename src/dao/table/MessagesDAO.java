package dao.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DatabaseAccessor;
import model.Message;

public class MessagesDAO extends DatabaseAccessor{



	public ArrayList<Message> selectMessageBySendUserId(int sendUserId) {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	    	//mysql文の用意
	    	String mysql = "select * from `Messages` where send_user_id = ? order by created_at DESC;";

	    	// DB へのコネクションを作成する
	        connection = createConnection();
	        // 実行するSQL文とパラメータを指定する
	        preparedStatement = connection.prepareStatement(mysql);
	        preparedStatement.setInt(1, sendUserId);

	        // SELECT 文の実行
	        System.out.println("mysql >"+preparedStatement.toString());
	        resultSet = preparedStatement.executeQuery();
	        //preparedStatement.execute();
	        // 取得した結果を全件取得する（複数 SELECT する場合は，リストを活用する）
	        ArrayList< Message> messages = new ArrayList<>();
	        while (resultSet.next()) {
	        	Message message = new Message();
	            message.setId(resultSet.getInt("message_id"));
	            message.setSendUserId(resultSet.getInt("send_user_id"));
	            message.setReceiveUserId(resultSet.getInt("receive_user_id"));
	            message.setMessageContents(resultSet.getString("message_contents"));
	            message.setCreatedAt(resultSet.getDate("created_at"));
	            messages.add(message);
	        }
	        return messages;
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
	public ArrayList<Message> selectMessageByReceiveUserId(int receiveUserId) {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	    	//mysql文の用意
	    	String mysql = "select * from `Messages` where receive_user_id = ? order by created_at DESC;";

	    	// DB へのコネクションを作成する
	        connection = createConnection();
	        // 実行するSQL文とパラメータを指定する
	        preparedStatement = connection.prepareStatement(mysql);
	        preparedStatement.setInt(1, receiveUserId);

	        // SELECT 文の実行
	        System.out.println("mysql >"+preparedStatement.toString());
	        resultSet = preparedStatement.executeQuery();
	        //preparedStatement.execute();
	        // 取得した結果を全件取得する（複数 SELECT する場合は，リストを活用する）
	        ArrayList< Message> messages = new ArrayList<>();
	        while (resultSet.next()) {
	        	Message message = new Message();
	            message.setId(resultSet.getInt("message_id"));
	            message.setSendUserId(resultSet.getInt("send_user_id"));
	            message.setReceiveUserId(resultSet.getInt("receive_user_id"));
	            message.setMessageContents(resultSet.getString("message_contents"));
	            message.setCreatedAt(resultSet.getDate("created_at"));
	            messages.add(message);
	        }
	        return messages;
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
	public ArrayList<Message> selectMessageBySendUserIdAndReceiveUserId(int sendUserId,int receiveUserId) {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	    	//mysql文の用意
	    	String mysql = "select * from `Messages` where send_user_id = ? And receive_user_id = ?  order by created_at DESC;";

	    	// DB へのコネクションを作成する
	        connection = createConnection();
	        // 実行するSQL文とパラメータを指定する
	        preparedStatement = connection.prepareStatement(mysql);
	        preparedStatement.setInt(1, sendUserId);
	        preparedStatement.setInt(2, receiveUserId);

	        // SELECT 文の実行
	        System.out.println("mysql >"+preparedStatement.toString());
	        resultSet = preparedStatement.executeQuery();
	        //preparedStatement.execute();
	        // 取得した結果を全件取得する（複数 SELECT する場合は，リストを活用する）
	        ArrayList< Message> messages = new ArrayList<>();
	        while (resultSet.next()) {
	        	Message message = new Message();
	            message.setId(resultSet.getInt("message_id"));
	            message.setSendUserId(resultSet.getInt("send_user_id"));
	            message.setReceiveUserId(resultSet.getInt("receive_user_id"));
	            message.setMessageContents(resultSet.getString("message_contents"));
	            message.setCreatedAt(resultSet.getDate("created_at"));
	            messages.add(message);
	        }
	        return messages;
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

	public Boolean insertMessage(int sendUserId,int receiveUserId,String message) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//mysql文の用意
			String mysql = "insert into `messages`(send_user_id,receive_user_id,message_contents) values(?,?,?)";

			// DB へのコネクションを作成する
			connection = createConnection();
			// 実行するSQL文とパラメータを指定する
			preparedStatement = connection.prepareStatement(mysql);
			preparedStatement.setInt(1, sendUserId);
			preparedStatement.setInt(2, receiveUserId);
			if(message.length()>1000000000){
				System.out.println("MesseagesDAO.insertMessage:[error]メッセージが長すぎる.メッセージを切り捨てて保存.");
				message = message.substring(0, 1000000000);
			}
			preparedStatement.setString(3, message);

			// SELECT 文の実行
	        System.out.println("mysql >"+preparedStatement.toString());
			preparedStatement.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			// クローズ処理
			close(connection, preparedStatement, resultSet);
		}
	}
}