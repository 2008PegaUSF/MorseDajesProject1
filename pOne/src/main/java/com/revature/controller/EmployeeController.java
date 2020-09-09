package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeController {

	public static void getRequestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get all form inputs
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		
		String description = request.getParameter("description");
		String cost = request.getParameter("cost");
		String gradingFormat = request.getParameter("gradingFormat");
		String eventType = request.getParameter("eventType");
		String justification = request.getParameter("justification");
		
		//Jesse's logic here; Probably passing all of the above strings as arguments in a Request object constructor
		
		//Method to insert all of the (necessary) input values into the 'requests' table in DB.
		//If first & last names are not part of the requests table, an additional query will have to be made first to locate the userid.
		
		request.getRequestDispatcher("/submitRequest").forward(request, response);
	}
	
	public static void getGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get uploaded file, store it somewhere...as serialized data in DB? Need clarification on this.
		
		request.getRequestDispatcher("/uploadGrade").forward(request, response);
		
	}

}
	