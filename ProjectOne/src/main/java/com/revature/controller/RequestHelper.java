package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String endpoint = request.getRequestURI();
		
		switch (endpoint) {
		
		case "/ProjectOne/api/login":
			AuthenticateController.login(request, response);
			break;
		case "/ProjectOne/api/logout":
			AuthenticateController.logout(request, response);
			break;
		case "/ProjectOne/api/navigate":
			NavigateController.getNavigation(request, response);
			break;
		case "/ProjectOne/api/submitRequest":
			EmployeeController.getRequestForm(request, response);
			break;
		case "/ProjectOne/api/uploadGrade":
			EmployeeController.getGrade(request, response);
			break;
		case "/ProjectOne/api/pendingRequests":
			SupervisorController.recordRequestVerdict(request, response);
			break;
		case "/ProjectOne/api/pendingGrades":
			SupervisorController.recordGradeVerdict(request, response);
			break;
		default:
			HomeController.getLoginPage(request,response);
			break;
		}
	}

}