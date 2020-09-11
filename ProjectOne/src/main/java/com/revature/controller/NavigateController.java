package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NavigateController {

	public static void getNavigation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		
		String s = request.getParameter("button");
		
		switch(s) {
		case "1":
			rd = request.getRequestDispatcher("/101.html");
			rd.forward(request, response);
			break;
		case "2":
			rd = request.getRequestDispatcher("/submitRequest.html");
			rd.forward(request, response);
			break;
		case "3":
			rd = request.getRequestDispatcher("/uploadGrade.html");
			rd.forward(request, response);
			break;
		case "4":
			rd = request.getRequestDispatcher("/viewGrades.html");
			rd.forward(request, response);
			break;
		}

	}

}
