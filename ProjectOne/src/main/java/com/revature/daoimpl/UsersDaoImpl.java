package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Logins;
import com.revature.beans.Users;
import com.revature.dao.UsersDao;
import com.revature.util.ConnFactory;

public class UsersDaoImpl implements UsersDao {
public static ConnFactory cf = ConnFactory.getInstance();

	public List<Users> getUsers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Users> getUsersByRequestId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Users getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void login() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void register() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void changeUsername(String n, String p) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void changePassword(String n, String p) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void addLoginTest(String s, String p) throws SQLException{
		Connection conn= cf.getConnection();
		PreparedStatement ptsmt= conn.prepareStatement("INSERT INTO LOGINS(USERNAME,PASSWORD) values(?,?)");
		ptsmt.setString(1, s);
		ptsmt.setString(2, p);
		ptsmt.execute();
	
	}
	
	public Logins getLoginByName(String uname) throws SQLException {
		Connection conn=cf.getConnection();//selecting all of the users of a certain username
		PreparedStatement pstmt= conn.prepareStatement("SELECT * FROM LOGINS WHERE USERNAME= ?");
		pstmt.setString(1, uname);
		Logins a=null;
		//filling the user object with the data from our query
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			a= new Logins(rs.getString(1), rs.getString(2),rs.getInt(3));
			
			}
		return a;//returning the user object
				
	}

	public Users getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users getUserByUsername(String uname) {
		// TODO Auto-generated method stub
		return null;
	}

	public void getLoginById(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public List<Logins> getLogins() throws SQLException {
		List<Logins> logList=new ArrayList<Logins>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM LOGINS");
		Logins a=null;
		while(rs.next()) {
			a=new Logins(rs.getString(1),rs.getString(2),rs.getInt(3));
			logList.add(a);}
		System.out.println(logList);
		return logList;
	}
	
	public static void main(String[] args) {
		UsersDaoImpl udi = new UsersDaoImpl();
		try {
			System.out.println(udi.getLoginByName("Jesse"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
