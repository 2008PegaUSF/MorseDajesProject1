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
<<<<<<< HEAD

=======
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		case "/ProjectOne/api/submitRequest":
			EmployeeController.getRequestForm(request, response);
			break;
		case "/ProjectOne/api/uploadGrade":
			EmployeeController.getGrade(request, response);
			break;
<<<<<<< HEAD
		case "/ProjectOne/api/pendingRequests":
			SupervisorController.recordRequestVerdict(request, response);
			break;
		case "/ProjectOne/api/pendingGrades":
			SupervisorController.recordGradeVerdict(request, response);
			break;
=======
		case "/ProjectOne/api/recordRequestVerdict":
			SupervisorController.recordRequestVerdict(request, response);
			break;
		case "/ProjectOne/api/recordGradeVerdict":
			SupervisorController.recordGradeVerdict(request, response);
			break;
		case "/ProjectOne/api/loadRequests":
			SupervisorController.loadRequests(request, response);
			break;
		case "/ProjectOne/api/loadRequestsEmployee":
			EmployeeController.loadRequests(request, response);
			break;
		case "/ProjectOne/api/loadRequestsEmployeeAmounts":
			EmployeeController.loadRequestsAmounts(request, response);
			break;
		case "/ProjectOne/api/uploadGrade.html/*":
			EmployeeController.getGradeFiles(request, response);
			break;
		case "/ProjectOne/api/cancelRequest":
			EmployeeController.cancelRequests(request, response);
			break;
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		default:
			HomeController.getLoginPage(request,response);
			break;
		}
	}

}