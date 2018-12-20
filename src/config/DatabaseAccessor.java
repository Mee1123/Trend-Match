package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAccessor {
	private final static String SERVER_NAME = "localhost";

	private final static String DATABASE_NAME = "";

	private final static String USER_NAME = "";

	private final static String PASSWORD = "";

	private final static String DRIVER_URL = "jdbc:mysql://" + SERVER_NAME + ":3306/" + DATABASE_NAME
			+ "?useUnicode=true&characterEncoding=utf-8";

	private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
//開始処理
	public static Connection createConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
			return con;
		} catch (ClassNotFoundException e) {
			System.out.println("Can’t Find JDBC Driver.\n");
		} catch (SQLException e) {
			System.out.println("Connection Error.\n");
		}
		return null;
	}
//汎用終了処理
	protected static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
			}
		}
	}
}