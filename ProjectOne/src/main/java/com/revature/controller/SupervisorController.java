package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Users;
import com.revature.daoimpl.RequestsDaoImpl;
import com.revature.daoimpl.UsersDaoImpl;

public class SupervisorController {
	
	public static RequestsDaoImpl rdi = new RequestsDaoImpl();
	public static UsersDaoImpl udi = new UsersDaoImpl();
	
	public static void recordRequestVerdict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public static void recordGradeVerdict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public static void deny(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession(false);
		Users user = udi.getUser((int) sesh.getAttribute("userid"));
		
		String userType = user.getUsertype();
		
		switch (userType) {
		//Function According to type of user
		}
		
	}
	
	public static void approve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession(false);
		Users user = udi.getUser((int) sesh.getAttribute("userid"));
		
		String userType = user.getUsertype();
		
		switch (userType) {
		//Function According to type of user
		}
		
	}
	
	public static void award(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession(false);
		Users user = udi.getUser((int) sesh.getAttribute("userid"));
		
		String userType = user.getUsertype();
		
		switch (userType) {
		//Function According to type of user
		}
		
	}

	public static void loadRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession(false);
		int userid = ((Integer) sesh.getAttribute("userid")).intValue();
		
		Users user = null;
		try {
			user = udi.getUserByUserId(userid);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String userType = user.getUsertype();
		
		String json = null;
		
		try {
			//json = rdi.getRequestsJSON();
			switch (userType) {
			case "Direct Supervisor":
				json = rdi.getPendingsJSON();
				break;
			case "Department Head":
				json = rdi.getSupervisorApprovedJSON();
				break;
			case "Benefits Coordinator":
				json = rdi.getDepartmentHeadApprovedJSON();
				break;
			default:
				json = rdi.getRequestsJSON();
				break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.write(json);
	}

}
