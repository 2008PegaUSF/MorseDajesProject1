package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticateController {

	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Poggers");
		
		System.out.println(request.getParameter("username"));
		
		String s = request.getParameter("username");
		
		//redirecting ---- NEED HTML PAGE WHERE WANT TO REDIRECT
		//response.sendRedirect("http://localhost:8080/ProjectOne/api/?");
	}
	
	public static void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Logout Poggers");
	}
}
