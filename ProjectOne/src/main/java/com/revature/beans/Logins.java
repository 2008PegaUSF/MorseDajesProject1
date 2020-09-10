package com.revature.beans;

public class Logins {
	protected String username;
	protected String password;
	protected int UserId;
	
	public Logins(String uName, String pword, int uId) {
		this.username=uName;
		this.password=pword;
		this.UserId=uId;
	}
	
	public Logins(int int1, String string, String string2) {
	this.UserId=int1;
	this.username=string;
	this.password=string2;
	}
	
	public Logins(String string, String string2) {
		
		this.username=string;
		this.password=string2;
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserId() {
		return UserId;
	}
	
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	@Override
	public String toString() {
		return "Logins [username=" + username + ", password=" + password + ", UserId=" + UserId + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + UserId;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logins other = (Logins) obj;
		if (UserId != other.UserId)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}