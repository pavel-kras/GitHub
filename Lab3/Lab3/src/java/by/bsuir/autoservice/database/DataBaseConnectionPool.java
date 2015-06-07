package by.bsuir.autoservice.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import by.bsuir.autoservice.manager.PropertiesManager;

public class DataBaseConnectionPool {
	private static BlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(
			3, true);

	String driver = PropertiesManager.getProperty("database", "driver.name");

	public void createPool() {
		String driver = PropertiesManager
				.getProperty("database", "driver.name");
		String url = PropertiesManager.getProperty("database", "url");
		String user = PropertiesManager.getProperty("database", "user");
		String password = PropertiesManager.getProperty("database", "password");
		for (int i = 0; i < 3; i++) {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				pool.add(DriverManager.getConnection(url, user, password));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = pool.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				pool.put(conn);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
