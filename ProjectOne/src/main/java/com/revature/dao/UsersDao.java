package com.revature.dao;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Logins;
import com.revature.beans.Users;

public interface UsersDao {
	public Users getUserByEmail(String email);
	public Users getUserByUsername(String uname);
	public List<Users> getUsers() throws SQLException;
	public List<Users> getUsersByRequestId(int id) throws SQLException;
	public Users getUser(int id);
	public Logins getLoginById(int id)throws SQLException;
	public void login() throws SQLException;
	public void register() throws SQLException;
	public void changeUsername(String n, String p) throws SQLException;
	public void changePassword(String n, String p) throws SQLException;
	public List<Logins> getLogins() throws SQLException;
}