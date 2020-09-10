package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Logins;
import com.revature.daoimpl.UsersDaoImpl;

public class AuthenticateController {

	public static UsersDaoImpl udi = new UsersDaoImpl();
	
	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Poggers");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " Poggers");
		
		Logins l = null;
		try {
			l = udi.getLoginByName(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (l == null) {
			System.out.println("Username Fail Poggers");
			RequestDispatcher rd = request.getRequestDispatcher("api/*"); //What is the request dispatcher? What does it do?
			rd.forward(request, response);
		} else if (l.getPassword().equals(password)) {
			System.out.println("Login Success Poggers");
			RequestDispatcher rd = request.getRequestDispatcher("/submitRequest.html"); //What is the request dispatcher? What does it do?
			rd.forward(request, response);
		} else {
			System.out.println("Login Fail Poggers");
			RequestDispatcher rd = request.getRequestDispatcher("api/*"); //What is the request dispatcher? What does it do?
			rd.forward(request, response);
		}
		
	}
	
	public static void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Logout Poggers");
	}
}
