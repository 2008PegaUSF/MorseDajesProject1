package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daoimpl.RequestsDaoImpl;

public class EmployeeController {

	public static void getRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get all form inputs
		//firstName, lastName, eventDate, eventTime, location, cost, eventType, gradingFormat, description, justification 
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
			rdi.createRequest(location,description,Double.parseDouble(cost),gradingFormat,eventType,1,justification,time,date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("api/login").forward(request, response);//This kicks you to the front page currently
	}
	
	public static void getGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get uploaded file, store it somewhere...as serialized data in DB? Need clarification on this.
		
		request.getRequestDispatcher("/uploadGrade").forward(request, response);
		
	}

}