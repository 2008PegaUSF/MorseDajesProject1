package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletTest extends HttpServlet{

	private static final long serialVersionUID = 6676985313879744963L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		System.out.println("Ya got me");
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		System.out.println("Post Up");
	}
}
