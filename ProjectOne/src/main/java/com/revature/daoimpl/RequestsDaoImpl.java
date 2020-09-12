package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.beans.Awarded;
import com.revature.beans.BencoApproved;
import com.revature.beans.Denied;
import com.revature.beans.DepartheadApproved;
import com.revature.beans.Pending;
import com.revature.beans.Requests;
import com.revature.beans.SupervisorApproved;
import com.revature.util.ConnFactory;

public class RequestsDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();

	public List<Requests> getRequests() throws SQLException {
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM REQUESTS");
		Requests a=null;
		while(rs.next()) {
			a= new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);}
		//System.out.println(rList);
		return rList;
	}
	
	public Requests getLastRequest() throws SQLException {
		Connection conn=cf.getConnection();
		Statement stmt= conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM REQUESTS");
		Requests a=null;
		while(rs.next()) {
			a= new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
		}
		return a;
	}

	public List<Requests> getPendings() throws SQLException {
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from pending);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		//System.out.println(rList);
		return rList;
	}

	public String getRequestsJSON() throws SQLException {
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM REQUESTS");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
	//	System.out.println(JSONObject);
		return JSONObject;
		
	}
	
	public String getPendingsJSON() throws SQLException {		
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from pending);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
	//	System.out.println(JSONObject);
		return JSONObject;	
	}
	
	public String getSupervisorApprovedJSON() throws SQLException {		
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from supervisorapproved);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
	//	System.out.println(JSONObject);
		return JSONObject;	
	}
	
	public String getDepartmentHeadApprovedJSON() throws SQLException {		
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from departheadapproved);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
	//	System.out.println(JSONObject);
		return JSONObject;	
	}
	
	public String getBenefitsCoordinatorApprovedJSON() throws SQLException {		
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from bencoapproved);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
	//	System.out.println(JSONObject);
		return JSONObject;	
	}
	
	public String getAwardedJSON() throws SQLException {		
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from awarded);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
	//	System.out.println(JSONObject);
		return JSONObject;	
	}
	
	public String getDeniedJSON() throws SQLException {		
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from denied);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
	//	System.out.println(JSONObject);
		return JSONObject;	
	}
	
	public List<Requests> getSuperApproveds() throws SQLException {
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from supervisorapproved);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		//System.out.println(rList);
		return rList;
	}

	public List<Requests> getDepartheadApproveds() throws SQLException {
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from departheadapproved);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		//System.out.println(rList);
		return rList;
	}


	public List<Requests> getBencoApproved() throws SQLException {
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from bencoapproved);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		//System.out.println(rList);
		return rList;
	}


	public List<Requests> getDenied() throws SQLException {
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from denied);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		//System.out.println(rList);
		return rList;
	}

	public List<Requests> getAwarded() throws SQLException {
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from requests where requestid in (select requestid from awarded);");
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
		}		
		//System.out.println(rList);
		return rList;
	}

	public Requests getRequestByReqId(int id) throws SQLException {
		Connection conn=cf.getConnection();//selecting all of the users of a certain Id
		PreparedStatement pstmt= conn.prepareStatement("SELECT * FROM USERS WHERE REQUESTID= ?");
		pstmt.setInt(1, id);
		Requests a=null;
		//filling the user object with the data from our query
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			a = new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			}
		//System.out.println(a);
		return a;//re
	}

	public List<Requests> getRequestsById(int id) throws SQLException {
		List<Requests> rList= new ArrayList<Requests>();
		Connection conn = cf.getConnection();
		//our prepared statement 
		PreparedStatement pstmt= conn.prepareStatement("SELECT * FROM REQUESTS WHERE USERID=?");
		pstmt.setInt(1, id);
		Requests a= null;
		//filling the arraylist with data from our query
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()){
			a= new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			rList.add(a);
			}
		//returning the arraylist
		return rList;		
	}

	public void createRequest(String location, String description, double cost,
		String gradingFormat, String eventType, int userId, String justification,
		String eventTime, String eventDate, String firstName, String lastName) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("insert into requests(REQUESTDATE,LOCATION,DESCRIPTION,COST,GRADINGFORMAT,EVENTTYPE,USERID,REQUESTTIME,JUSTIFICATION,EVENTTIME,EVENTDATE,FIRSTNAME,LASTNAME) "
				+ "values(current_date,?,?,?,?,?,?,current_time,?,"+eventTime+","+eventDate+",?,?)");
		pstmt.setString(1,location);
		pstmt.setString(2,description);
		pstmt.setDouble(3, cost);
		pstmt.setString(4, gradingFormat);
		pstmt.setString(5,eventType);
		pstmt.setInt(6,userId);
		pstmt.setString(7,justification);
		pstmt.setString(8, firstName);
		pstmt.setString(9, lastName);
		pstmt.execute();
	}

	public void createAwarded(int id) throws SQLException {
	Connection conn=cf.getConnection();
	PreparedStatement pstmt=conn.prepareStatement("INSERT INTO AWARDED(REQUESTID) values (?)");
	pstmt.setInt(1, id);
	pstmt.execute();
	}

	public void createDenied(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO DENIED(REQUESTID) values (?)");
		pstmt.setInt(1, id);
		pstmt.execute();
	}

	public void createPending(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO PENDING(REQUESTID) values (?)");
		pstmt.setInt(1, id);
		pstmt.execute();
	}

	public void createSupervisorApproved(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO AWARDED(REQUESTID) values (?)");
		pstmt.setInt(1, id);
		pstmt.execute();
	}

	public void createBencoApproved(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO BENCOAPPROVED(REQUESTID) values (?)");
		pstmt.setInt(1, id);
		pstmt.execute();
	}

	public void deletePending(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("DELETE FROM PENDING WHERE REQUESTID=?");
		pstmt.setInt(1, id);
		pstmt.execute();
	}
}
