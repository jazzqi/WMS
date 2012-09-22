package real.action.sql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory factory = null;
	private String driver = "";
	private String url = "";
	private String user = "";
	private String password = "";
	private Connection conn;

	private ConnectionFactory() throws Exception {
		
		Properties properties = new Properties();
		FileInputStream input = null;
		try {
			input = new FileInputStream("bin\\real\\action\\sql\\db.properties");
			properties.load(input);
			
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");

			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static synchronized Connection getConnection() throws Exception {
		if (factory == null) {
			factory = new ConnectionFactory();
		}
		return factory.conn;
	}
	
	public static void closeConnection() throws Exception {
		if (factory != null)
			factory.conn.close();
		factory = null;
	}
}
