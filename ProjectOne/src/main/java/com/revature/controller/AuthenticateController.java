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
<<<<<<< HEAD
=======
import com.revature.daoimpl.RequestsDaoImpl;
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
import com.revature.daoimpl.UsersDaoImpl;

public class AuthenticateController {

	public static UsersDaoImpl udi = new UsersDaoImpl();
	
	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
<<<<<<< HEAD
=======
		
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		Logins l = null;
		Users u = null;
		try {
			l = udi.getLoginByName(username);
<<<<<<< HEAD
			u = udi.getUserByUserId(l.getUserId());
=======
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (l == null) { //Username is invalid
			RequestDispatcher rd = request.getRequestDispatcher("api/*"); //What is the request dispatcher? What does it do?
			rd.forward(request, response);
<<<<<<< HEAD
		} else if (l.getPassword().equals(password)) { //Valid Login
			if (u.getUsertype().equals("Employee")) {//Go to submission page if you're an employee
				RequestDispatcher rd = request.getRequestDispatcher("/submitRequest.html");
=======
			
		} else if (l.getPassword().equals(password)) { //Valid Login
			try {
				u = udi.getUserByUserId(l.getUserId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (u.getUsertype().equals("Employee")) {//Go to submission page if you're an employee
				RequestDispatcher rd = request.getRequestDispatcher("/101.html");
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
				
				HttpSession sesh = request.getSession();//Create a session w/ the user id
				sesh.setAttribute("userid", new Integer(l.getUserId()));
				
				rd.forward(request, response);
			} else {//Go to the view page otherwise
				RequestDispatcher rd = request.getRequestDispatcher("/pendingRequests.html");
				
				HttpSession sesh = request.getSession();//Create a session w/ the user id
				sesh.setAttribute("userid", new Integer(l.getUserId()));
				
				rd.forward(request, response);
			}
<<<<<<< HEAD
		} else { //Password doesn't match
			RequestDispatcher rd = request.getRequestDispatcher("api/*"); //What is the request dispatcher? What does it do?
			rd.forward(request, response);
=======
			
		} else { //Password doesn't match
			RequestDispatcher rd = request.getRequestDispatcher("api/*"); //What is the request dispatcher? What does it do?
			rd.forward(request, response);
			
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		}
	}
	
	public static void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
=======
		request.getSession().invalidate();
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
		RequestDispatcher rd = request.getRequestDispatcher("api/"); //What is the request dispatcher? What does it do?
		rd.forward(request, response);
	}
}
