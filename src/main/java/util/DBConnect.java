package util;

import java.sql.*;

public class DBConnect {

	private static String url =
			"jdbc:mysql://localhost:3306/storedb"
			+ "?useUnicode=true"
			+ "&characterEncoding=UTF-8"
			+ "&serverTimezone=UTC";

	private static String user = "root";
	private static String password = "12345";

	public static Connection getConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection(url, user, password);
	}
}