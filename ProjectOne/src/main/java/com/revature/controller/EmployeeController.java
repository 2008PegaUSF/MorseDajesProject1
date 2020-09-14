package com.revature.controller;

import java.io.IOException;
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
		
		HttpSession sesh = request.getSession(false);
		if (sesh == null) {
			request.getRequestDispatcher("api/*").forward(request, response);
			System.out.println("Not Logged In");
		} else {
			int userid = (int) sesh.getAttribute("userid");
			
			//Get all form inputs
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
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
			
			RequestsDaoImpl rdi = new RequestsDaoImpl();
			try {				
				
				//Create request
				rdi.createRequest(location, description, Double.parseDouble(cost), gradingFormat, eventType, userid, justification, time, date, firstName, lastName);
				Requests r = rdi.getLastRequest();
				int requestid = r.getRequestid();
				
				// Retrieves files from <input type="file" name="file" multiple> 
				 List<Part> fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList());
				 
				 //Add files to table, and request to pending
				 rdi.createPending(requestid);
				 rdi.insertFiles(fileParts, requestid);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("/submitRequest.html").forward(request, response);//This reloads the same page
		}
	}
	

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
}