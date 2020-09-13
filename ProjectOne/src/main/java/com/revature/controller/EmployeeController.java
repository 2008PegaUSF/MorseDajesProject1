package com.revature.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimpl.RequestsDaoImpl;
import com.revature.util.ConnFactory;

@MultipartConfig
public class EmployeeController {

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
				 ConnFactory cf = ConnFactory.getInstance();
				 Connection conn = cf.getConnection();
				 
				//Get the requestid of the request we are about to submit (to add to the requestfiles table if necessary)
				PreparedStatement pr = conn.prepareStatement("select nextval('requests_requestid_seq') from requests;");
				ResultSet rs = pr.executeQuery();
				rs.next();
				int requestid = rs.getInt(1);
				
				//Reset sequence value after query
				PreparedStatement prep = conn.prepareStatement("SELECT SETVAL((SELECT pg_get_serial_sequence('requests', 'requestid')), ?, false);");
				prep.setInt(1, requestid);
				prep.executeQuery();
				
				//Create request
				rdi.createRequest(location, description, Double.parseDouble(cost), gradingFormat, eventType, userid, justification, time, date, firstName, lastName);
			
				// Retrieves files from <input type="file" name="file" multiple> 
				 List<Part> fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList());
				 
				    for (Part filePart : fileParts) {
				    	if (filePart != null) {
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

}