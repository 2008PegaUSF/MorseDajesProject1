package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticateController {

	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Poggers");
		
		System.out.println(request.getParameter("username"));
		
		RequestDispatcher rd = request.getRequestDispatcher("/submitRequest.html"); //What is the request dispatcher? What does it do?
		
		rd.forward(request, response);
	}
	
	public static void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Logout Poggers");
	}
}
