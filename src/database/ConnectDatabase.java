package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

	public static Connection connectDB() {

		String url = "jdbc:mysql://localhost:3306/mis?serverTimezone=GMT%2B8";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
		}

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, "root", "123456");
		} catch (SQLException e) {
		}

		return con;
	}
}
