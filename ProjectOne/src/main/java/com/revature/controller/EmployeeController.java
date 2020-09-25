package com.revature.controller;

import java.io.IOException;
<<<<<<< HEAD
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimpl.RequestsDaoImpl;

public class EmployeeController {

	public static void getRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
=======
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.revature.beans.Requests;
import com.revature.beans.Users;
import com.revature.daoimpl.RequestsDaoImpl;
import com.revature.daoimpl.UsersDaoImpl;
import com.revature.util.ConnFactory;

@MultipartConfig
public class EmployeeController {

	public static RequestsDaoImpl rdi = new RequestsDaoImpl();
	public static UsersDaoImpl udi = new UsersDaoImpl();
	
	public static synchronized void getRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		
		HttpSession sesh = request.getSession(false);
		if (sesh == null) {
			request.getRequestDispatcher("api/*").forward(request, response);
			System.out.println("Not Logged In");
		} else {
			int userid = (int) sesh.getAttribute("userid");
			
<<<<<<< HEAD
			//Get all form inputs		
=======
			//Get all form inputs
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
			String date = request.getParameter("eventDate");
			String time = request.getParameter("eventTime");
			String location = request.getParameter("location");
			
			String description = request.getParameter("description");
			String cost = request.getParameter("cost");
			String gradingFormat = request.getParameter("gradingFormat");
			String eventType = request.getParameter("eventType");
			String justification = request.getParameter("justification");
			
			date = "'"+date+"'";
			time = "'"+time+":00'";
			
<<<<<<< HEAD
			RequestsDaoImpl rdi = new RequestsDaoImpl();
			try {
				rdi.createRequest(location,description,Double.parseDouble(cost),gradingFormat,eventType,userid,justification,time,date);
=======
			//Calculate projected reimbursement amount
			double projectedAmount = 0;
			double costAsDouble = Double.parseDouble(cost);
			
			switch (eventType) {
			
			case "University course": projectedAmount= costAsDouble * 0.8;
				break;
				
			case "Seminar": projectedAmount= costAsDouble * 0.6;
				break;
				
			case "Certification prep": projectedAmount= costAsDouble * 0.75;
				break;
				
			case "Certification": projectedAmount= costAsDouble;
				break;
			
			case "Technical training": projectedAmount= costAsDouble * 0.9;
				break;
			
			case "Other": projectedAmount= costAsDouble * 0.3;
				break;
				
			default: System.out.println("Event type error.");
			}
			
			RequestsDaoImpl rdi = new RequestsDaoImpl();
			try {				
				
				//Create request
				rdi.createRequest(location, description, Double.parseDouble(cost), gradingFormat, eventType, userid, justification, time, date, firstName, lastName,projectedAmount);
				Requests r = rdi.getLastRequest();
				int requestid = r.getRequestid();
				
				// Retrieves files from <input type="file" name="file" multiple> 
				 List<Part> fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList());
				 
				 //Add files to table, and request to pending
				 rdi.createPending(requestid);
				 rdi.insertFiles(fileParts, requestid);
			
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("/submitRequest.html").forward(request, response);//This reloads the same page
		}
	}
	
<<<<<<< HEAD
	public static void getGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get uploaded file, store it somewhere...as serialized data in DB? Need clarification on this.
		
		request.getRequestDispatcher("/uploadGrade").forward(request, response);
		
	}

=======

	public static void getGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesh = request.getSession(false);
		if (sesh == null) {
			request.getRequestDispatcher("api/*").forward(request, response);
			System.out.println("Not Logged In");
		} else {
			
			//Get the value of the request ID from the radio button selected
			String[] requestIdVal = request.getParameterValues("selection");
			//Convert to int
			int requestID = Integer.parseInt(requestIdVal[0]);
			
			//Get grading format
			String format = request.getParameter("gradingFormat");
			
			//Get file <input type="file" name="gradeFile">
		    Part file = request.getPart("gradeFile"); 
		    String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		    
		    //Convert to byte array
		    InputStream fileStream = file.getInputStream();
		    byte[] bytes = IOUtils.toByteArray(fileStream);
		    
		    ConnFactory cf = ConnFactory.getInstance();
		    Connection conn = cf.getConnection();
			try {
				PreparedStatement ps = conn.prepareStatement("INSERT INTO gradespresentations VALUES (?, ?, ?, ?)");
				ps.setInt(1, requestID);
				ps.setString(2, format);
				ps.setString(3, fileName);
				ps.setBytes(4, bytes);
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("/uploadGrade.html").forward(request, response);
		}	
	}
	
	public static void getGradeFiles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession sesh = request.getSession(false);
		if (sesh == null) {
			request.getRequestDispatcher("api/*").forward(request, response);
			System.out.println("Not Logged In");
		} else {
			//Get request Id from the URI
			String URI = request.getRequestURI();
			String requestIdString = URI.substring(URI.lastIndexOf('/')+1, URI.length());
			
			//Change to int for following method
			int requestid = Integer.parseInt(requestIdString);
			
			RequestsDaoImpl rdi = new RequestsDaoImpl();
			
			String JSONfiles;
			try {
				JSONfiles = rdi.getGradesPresentationsJSON(requestid);
				PrintWriter pw = response.getWriter();
		        pw.write(JSONfiles);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
	
	public static void loadRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession(false);
		int userid = ((Integer) sesh.getAttribute("userid")).intValue();
		
		String json = null;
		
		try {
			json = rdi.getRequestsByIdJSON(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.write(json);
	}


	public static void loadRequestsAmounts(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sesh = request.getSession(false);
		int userid = ((Integer) sesh.getAttribute("userid")).intValue();
		
		String json = null;
		
		try {
			json = rdi.getRequestsJSON3(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.write(json);
		
	}
	
	public static void cancelRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession sesh = request.getSession(false);
		if (sesh == null) {
			request.getRequestDispatcher("api/*").forward(request, response);
			System.out.println("Not Logged In");
		} else {
			
			//Get the value of the request ID from the radio button selected
			String[] selections = request.getParameterValues("selection");
			int[] requestids = new int[selections.length];
			
			for (int i = 0; i < selections.length; i++) {
				requestids[i] = Integer.parseInt(selections[i]);
			}
		    
			for (int requestid : requestids) {
				try {
					rdi.deleteRequest(requestid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		    
			request.getRequestDispatcher("/viewGrades.html").forward(request, response);
		}
	}
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
}