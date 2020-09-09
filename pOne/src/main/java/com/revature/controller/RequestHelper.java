package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String endpoint = request.getRequestURI();
		
		switch (endpoint) {
		
		case "/login":
			AuthenticateController.login(request, response);
			break;
			
		case "/logout":
			AuthenticateController.logout(request, response);
			break;
		
		case "/submitRequest":
			EmployeeController.getRequestForm(request, response);
			break;
			
		case "/uploadGrade":
			EmployeeController.getGrade(request, response);
			break;
			
		case "/pendingRequests":
			SupervisorController.recordRequestVerdict(request, response);
			break;
			
		case "/pendingGrades":
			SupervisorController.recordGradeVerdict(request, response);
			break;
		}
	}

}
