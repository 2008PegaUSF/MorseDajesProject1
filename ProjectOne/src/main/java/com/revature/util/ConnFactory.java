package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	//Singleton Factory
	//private static instance of itself
	private static ConnFactory cf = new ConnFactory();
	
	//No args constructor
	private ConnFactory() {
		super();
	}
	
	//public static synchronized "getter" method
	public static synchronized ConnFactory getInstance() {
		if (cf == null) {
			cf = new ConnFactory();
		}
		
		return cf;
	}
	
	//Methods that do stuff
	// Get connected! For free! (free!) with education con-nec-tion!
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("database.properties");
			prop.load(inputStream);
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
