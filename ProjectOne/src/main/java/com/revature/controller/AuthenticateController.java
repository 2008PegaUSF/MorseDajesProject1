package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Logins;
import com.revature.beans.Users;
import com.revature.daoimpl.UsersDaoImpl;

public class AuthenticateController {

	public static UsersDaoImpl udi = new UsersDaoImpl();
	
	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Logins l = null;
		Users u = null;
		try {
			l = udi.getLoginByName(username);
			u = udi.getUserByUserId(l.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (l == null) { //Username is invalid
			RequestDispatcher rd = request.getRequestDispatcher("api/*"); //What is the request dispatcher? What does it do?
			rd.forward(request, response);
		} else if (l.getPassword().equals(password)) { //Valid Login
			if (u.getUsertype().equals("Employee")) {//Go to submission page if you're an employee
				RequestDispatcher rd = request.getRequestDispatcher("/submitRequest.html");
				
				HttpSession sesh = request.getSession();//Create a session w/ the user id
				sesh.setAttribute("userid", new Integer(l.getUserId()));
				
				rd.forward(request, response);
			} else {//Go to the view page otherwise
				RequestDispatcher rd = request.getRequestDispatcher("/pendingRequests.html");
				
				HttpSession sesh = request.getSession();//Create a session w/ the user id
				sesh.setAttribute("userid", new Integer(l.getUserId()));
				
				rd.forward(request, response);
			}
		} else { //Password doesn't match
			RequestDispatcher rd = request.getRequestDispatcher("api/*"); //What is the request dispatcher? What does it do?
			rd.forward(request, response);
		}
	}
	
	public static void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("api/"); //What is the request dispatcher? What does it do?
		rd.forward(request, response);
	}
}
