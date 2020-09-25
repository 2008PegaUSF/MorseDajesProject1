package com.revature.daoimpl;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.Date;
=======
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Awarded;
import com.revature.beans.BencoApproved;
import com.revature.beans.Denied;
import com.revature.beans.DepartheadApproved;
import com.revature.beans.Pending;
import com.revature.beans.Requests;
import com.revature.beans.SupervisorApproved;
=======
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.beans.PendingGrades;
import com.revature.beans.Requests;
import com.revature.beans.gradespresentations;
import com.revature.beans.requestfiles;
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
import com.revature.util.ConnFactory;

public class RequestsDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();

	public List<Requests> getRequests() throws SQLException {
<<<<<<< HEAD
			List<Requests> rList=new ArrayList<Requests>();
			Connection conn=cf.getConnection();
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM REQUESTS");
			Requests a=null;
			while(rs.next()) {
				a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
				rList.add(a);}
			System.out.println(rList);
			return rList;
		}


	public List<Pending> getPendings() throws SQLException {
		List<Pending> rList=new ArrayList<Pending>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM PENDING");
		Pending a=null;
		while(rs.next()) {
			a=new Pending(rs.getInt(1));
			rList.add(a);}
		System.out.println(rList);
		return rList;
	}

	public List<SupervisorApproved> getSuperApproveds() throws SQLException {
		List<SupervisorApproved> rList=new ArrayList<SupervisorApproved>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM SupervisorApproved");
		SupervisorApproved a=null;
		while(rs.next()) {
			a=new SupervisorApproved(rs.getInt(1));
			rList.add(a);}
		System.out.println(rList);
		return rList;
	}

	public List<DepartheadApproved> getDepartheadApproveds() throws SQLException {
		List<DepartheadApproved> rList=new ArrayList<DepartheadApproved>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM DepartheadApproved");
		DepartheadApproved a=null;
		while(rs.next()) {
			a=new DepartheadApproved(rs.getInt(1));
			rList.add(a);}
		System.out.println(rList);
=======
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
	
	public String getRequestsJSON2(int id) throws SQLException {
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("SELECT REQUESTID,DESCRIPTION,GRADINGFORMAT,EVENTDATE,EVENTTYPE FROM REQUESTS WHERE USERID = ?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			rList.add(a);
		}		
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
	//	System.out.println(JSONObject);
		return JSONObject;
		
	}
	
	public String getRequestsJSON3(int id) throws SQLException {
		List<Requests> rList=new ArrayList<Requests>();
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("SELECT REQUESTID,EVENTDATE,EVENTTYPE,DESCRIPTION,GRADINGFORMAT,PROJECTEDAMOUNT,AWARDEDAMOUNT FROM REQUESTS WHERE USERID = ?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		Requests a=null;
		while(rs.next()) {
			a=new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7));
			rList.add(a);}		
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
	//	System.out.println(JSONObject);
		return JSONObject;

	}
	
	public String getRequestsByIdJSON(int id) throws SQLException {
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
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		return rList;
	}


<<<<<<< HEAD
	public List<BencoApproved> getBencoApproved() throws SQLException {
		List<BencoApproved> rList=new ArrayList<BencoApproved>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BencoApproved");
		BencoApproved a=null;
		while(rs.next()) {
			a=new BencoApproved(rs.getInt(1));
			rList.add(a);}
		System.out.println(rList);
=======
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
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		return rList;
	}


<<<<<<< HEAD
	public List<Denied> getDenieds() throws SQLException {
		List<Denied> rList=new ArrayList<Denied>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Denied");
		Denied a=null;
		while(rs.next()) {
			a=new Denied(rs.getInt(1));
			rList.add(a);}
		System.out.println(rList);
		return rList;
	}

	public List<Awarded> getAwarded() throws SQLException {
		List<Awarded> rList=new ArrayList<Awarded>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Awarded");
		Awarded a=null;
		while(rs.next()) {
			a=new Awarded(rs.getInt(1));
			rList.add(a);}
		System.out.println(rList);
=======
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
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		return rList;
	}

	public Requests getRequestByReqId(int id) throws SQLException {
		Connection conn=cf.getConnection();//selecting all of the users of a certain Id
<<<<<<< HEAD
		PreparedStatement pstmt= conn.prepareStatement("SELECT * FROM USERS WHERE REQUESTID= ?");
=======
		PreparedStatement pstmt= conn.prepareStatement("SELECT * FROM REQUESTS WHERE REQUESTID= ?");
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		pstmt.setInt(1, id);
		Requests a=null;
		//filling the user object with the data from our query
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
<<<<<<< HEAD
			a = new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			
			}
		System.out.println(a);
=======
			a = new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getDouble(16));
		}
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
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
<<<<<<< HEAD
			a= new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
=======
			a= new Requests(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
			rList.add(a);
			}
		//returning the arraylist
		return rList;		
	}

	public void createRequest(String location, String description, double cost,
		String gradingFormat, String eventType, int userId, String justification,
<<<<<<< HEAD
		String eventTime, String eventDate) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("insert into requests(REQUESTDATE,LOCATION,DESCRIPTION,COST,GRADINGFORMAT,EVENTTYPE,USERID,REQUESTTIME,JUSTIFICATION,EVENTTIME,EVENTDATE) "
				+ "values(current_date,?,?,?,?,?,?,current_time,?,"+eventTime+","+eventDate+")");
=======
		String eventTime, String eventDate, String firstName, String lastName) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("insert into requests(REQUESTDATE,LOCATION,DESCRIPTION,COST,GRADINGFORMAT,EVENTTYPE,USERID,REQUESTTIME,JUSTIFICATION,EVENTTIME,EVENTDATE,FIRSTNAME,LASTNAME) "
				+ "values(current_date,?,?,?,?,?,?,current_time,?,"+eventTime+","+eventDate+",?,?)");
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		pstmt.setString(1,location);
		pstmt.setString(2,description);
		pstmt.setDouble(3, cost);
		pstmt.setString(4, gradingFormat);
		pstmt.setString(5,eventType);
		pstmt.setInt(6,userId);
		pstmt.setString(7,justification);
<<<<<<< HEAD
		//pstmt.setTime(8, eventTime); Date and Time are coming from a form with restricted values (not open to injection)
		//pstmt.setDate(9,eventDate);
		System.out.println(pstmt.toString());
=======
		pstmt.setString(8, firstName);
		pstmt.setString(9, lastName);
		pstmt.execute();
	}
	
	public void createRequest(String location, String description, double cost,
		String gradingFormat, String eventType, int userId, String justification,
		String eventTime, String eventDate,String fname,String lname, double pAmount) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO REQUESTS(REQUESTDATE,LOCATION,DESCRIPTION,COST,GRADINGFORMAT,EVENTTYPE,USERID,REQUESTTIME,JUSTIFICATION,EVENTTIME,EVENTDATE,FIRSTNAME, LASTNAME,PROJECTEDAMOUNT)values(current_date,?,?,?,?,?,?,current_time,?,"+eventTime+","+eventDate+",?,?,?)");
		pstmt.setString(1,location);
		pstmt.setString(2,description);
		pstmt.setDouble(3, cost);
		pstmt.setString(4, gradingFormat);
		pstmt.setString(5,eventType);
		pstmt.setInt(6,userId);
		pstmt.setString(7,justification);
		pstmt.setString(8, fname);
		pstmt.setString(9, lname);
		pstmt.setDouble(10, pAmount);
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
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
<<<<<<< HEAD
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO AWARDED(REQUESTID) values (?)");
=======
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO SUPERVISORAPPROVED(REQUESTID) values (?)");
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	
	public void createDepartmentHeadApproved(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO DEPARTHEADAPPROVED(REQUESTID) values (?)");
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		pstmt.setInt(1, id);
		pstmt.execute();
	}

	public void createBencoApproved(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO BENCOAPPROVED(REQUESTID) values (?)");
		pstmt.setInt(1, id);
		pstmt.execute();
	}

<<<<<<< HEAD
=======
	public void deleteRequest(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("DELETE FROM REQUESTS WHERE REQUESTID=?");
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
	public void deletePending(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("DELETE FROM PENDING WHERE REQUESTID=?");
		pstmt.setInt(1, id);
		pstmt.execute();
	}
<<<<<<< HEAD
=======
	
	public void deleteSupervisorApproved(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("DELETE FROM SUPERVISORAPPROVED WHERE REQUESTID=?");
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	
	public void deleteDepartmentHeadApproved(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("DELETE FROM DEPARTHEADAPPROVED WHERE REQUESTID=?");
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	
	public void deleteBencoApproved(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("DELETE FROM BENCOAPPROVED WHERE REQUESTID=?");
		pstmt.setInt(1, id);
		pstmt.execute();
	}
	
	public void insertFiles(List<Part> fileParts, int requestid) throws SQLException, IOException {
		Connection conn = cf.getConnection();
		for (Part filePart : fileParts) {
	    	if (filePart.getSize() > 0) {
		        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		        
		        //Create InputStream and convert to byte[]
		        InputStream fileStream = filePart.getInputStream();
		        byte[] bytes = IOUtils.toByteArray(fileStream);
		        
		    	PreparedStatement ps = conn.prepareStatement("INSERT INTO requestfiles VALUES (?, ?, ?)");
				ps.setInt(1, requestid);
				ps.setString(2, fileName);
				ps.setBytes(3, bytes);
				ps.executeUpdate();
				ps.close();
	    	}
	    }
	}
	
	public List<PendingGrades> getGrades() throws SQLException {
		List<PendingGrades> rList=new ArrayList<PendingGrades>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM GRADESPRESENTATIONS");
		PendingGrades a=null;
		while(rs.next()) {
			a=new PendingGrades(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getBytes(4), rs.getString(5));
			rList.add(a);}
		System.out.println(rList);
		return rList;
	}

	public PendingGrades getGradeById(int id) throws SQLException {
		Connection conn=cf.getConnection();//selecting all of the users of a certain Id
		PreparedStatement pstmt= conn.prepareStatement("SELECT * FROM GRADESPRESENTATIONS WHERE REQUESTID= ?");
		pstmt.setInt(1, id);
		PendingGrades a=null;
		//filling the user object with the data from our query
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			a = new PendingGrades(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBytes(4), rs.getString(5));
			
			}
		System.out.println(a);
		return a;//re
	}

	public void createGrade(String s, String t) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO GRADESPRESENTATIONS(GRADINGFORMAT,FILENAME) values (?,?)");
		pstmt.setString(1, s);
		pstmt.setString(2, t);
		pstmt.execute();
	}

	public void deletePendingGrade(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("DELETE FROM GRADESPRESENTATIONS WHERE REQUESTID=?");
		pstmt.setInt(1, id);
		pstmt.execute();
			
	}
	

	public String getGradesJSON() throws SQLException {
		List<PendingGrades> rList=new ArrayList<PendingGrades>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM GRADESPRESENTATIONS");
		PendingGrades a=null;
		while(rs.next()) {
			a=new PendingGrades(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4));
			rList.add(a);}
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
	//	System.out.println(JSONObject);
		return JSONObject;	
	}
	
	public List<requestfiles> getRequestFiles() throws SQLException {
		List<requestfiles> rList=new ArrayList<requestfiles>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM requestfiles");
		requestfiles a=null;
		while(rs.next()) {
			a=new requestfiles(rs.getInt(1),rs.getString(2),rs.getBytes(3),rs.getString(4));
			rList.add(a);}
		System.out.println(rList);
		return rList;
	}
	
	public String getRequestFilesJSON(int id) throws SQLException {
		List<requestfiles> rList=new ArrayList<requestfiles>();
		Connection conn=cf.getConnection();		
		PreparedStatement pstmt= conn.prepareStatement("SELECT * FROM REQUESTFILES WHERE USERID=?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		requestfiles a=null;
		while(rs.next()) {
			a=new requestfiles(rs.getInt(1),rs.getString(2),rs.getBytes(3),rs.getString(4));
			rList.add(a);}
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
	//	System.out.println(JSONObject);
		return JSONObject;
	}
	
	
	
	public void createRequestFiles(int id, String dname, byte[] file, String ext) throws SQLException{
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO REQUESTFILES(REQUESTID,DOCNAME,FILE,EXTENSION) values (?,?,?,?)");
		pstmt.setInt(1, id);
		pstmt.setString(2, dname);
		pstmt.setBytes(3, file);
		pstmt.setString(4,ext);
		pstmt.execute();
	}
	
	public void deleteRequestFiles(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("DELETE FROM REQUESTFILES WHERE REQUESTID=?");
		pstmt.setInt(1, id);
		pstmt.execute();		
	}
	
	public List<gradespresentations> getGradesPresentations() throws SQLException {
		List<gradespresentations> rList=new ArrayList<gradespresentations>();
		Connection conn=cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM gradespresentations");
		gradespresentations a=null;
		while(rs.next()) {
			a=new gradespresentations(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBytes(4),rs.getString(5));
			rList.add(a);}
		System.out.println(rList);
		return rList;
	}
	
	
	public String getGradesPresentationsJSON(int id) throws SQLException {
		List<gradespresentations> rList=new ArrayList<gradespresentations>();
		Connection conn=cf.getConnection();
		PreparedStatement pstmt= conn.prepareStatement("SELECT * FROM GRADESPRESENTATIONS WHERE REQUESTID = ?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		gradespresentations a=null;
		while(rs.next()) {
			a=new gradespresentations(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBytes(4),rs.getString(5));
			rList.add(a);
		}
		//System.out.println(rList);
		GsonBuilder gboi=new GsonBuilder();
		Gson gson=gboi.create();			 
		String JSONObject=gson.toJson(rList);		
		//System.out.println(JSONObject);
		return JSONObject;
	}
	
	
	
	public void createGradesPresentations(int id, String format, String dname, byte[] file, String ext) throws SQLException{
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("INSERT INTO GRADESPRESENTATIONS(REQUESTID,FORMAT,DOCNAME,FILE,EXTENSION) values (?,?,?,?,?)");
		pstmt.setInt(1, id);
		pstmt.setString(2, format);
		pstmt.setString(3, dname);
		pstmt.setBytes(4,file);
		pstmt.setString(5,ext);
		pstmt.execute();
	}
	
	public void deleteGradesPresentations(int id) throws SQLException {
		Connection conn=cf.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("DELETE FROM GRADESPRESENTATIONS WHERE REQUESTID=?");
		pstmt.setInt(1, id);
		pstmt.execute();
	}
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
}
