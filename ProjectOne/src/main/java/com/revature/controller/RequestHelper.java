package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Request Helper");
		
		System.out.println(request.getRequestURI());
		
		String s = request.getRequestURI();
		
		switch(s) {
		case "/ProjectOne/api/login":
			AuthenticateController.login(request, response);
			break;
		case "/ProjectOne/api/logout":
			AuthenticateController.logout(request, response);
			break;
		case "/ProjectOne/api/pendingGrades":
			SupervisorController.recordGradeVerdict(request, response);
		case "/ProjectOne/api/pendingRequests":
			SupervisorController.recordRequestVerdict(request, response);
		}
	}

}
