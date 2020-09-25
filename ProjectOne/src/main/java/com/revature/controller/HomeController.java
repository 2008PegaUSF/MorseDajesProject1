package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {
	
	public static void getLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login.html"); //What is the request dispatcher? What does it do?
		
		rd.forward(request, response);
	}
<<<<<<< HEAD
=======
	
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
}
