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
		List<Users> uList=new ArrayList<Users>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users");
		Users a=null;
		while(rs.next()) {
			a=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getString(7));
			uList.add(a);}
		return uList;
	}

	public Users getUserByUserId(int id) throws SQLException {
		Connection conn=cf.getConnection();//selecting all of the users of a certain Id
		PreparedStatement pstmt= conn.prepareStatement("select * from users where userid = ?");
		pstmt.setInt(1, id);
		Users a=null;
		//filling the user object with the data from our query
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			a = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getString(7));
		}
		//System.out.println(a);
		return a;
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


	public Users getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users getUserByUsername(String uname) {
		// TODO Auto-generated method stub
		return null;
	}

	public Logins getLoginById(int id) throws SQLException {
		Connection conn=cf.getConnection();//selecting all of the users of a certain Id
		PreparedStatement pstmt= conn.prepareStatement("SELECT * FROM LOGINS WHERE USERID= ?");
		pstmt.setInt(1, id);
		Logins a=null;
		//filling the user object with the data from our query
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			a = new Logins(rs.getString(1), rs.getString(2),rs.getInt(3));
			
			}
		return a;
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
		return logList;
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

	public List<Users> getUsersByRequestId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeBalance(double d, int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("UPDATE USERS SET BALANCE=BALANCE+? WHERE USERID=?");
		pstmt.setDouble(1, d);
		pstmt.setInt(2, id);
		pstmt.execute();		
	}

	@Override
	public Users getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

	

