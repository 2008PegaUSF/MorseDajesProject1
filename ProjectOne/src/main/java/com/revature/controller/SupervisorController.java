package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daoimpl.RequestsDaoImpl;

public class SupervisorController {
	
	public static RequestsDaoImpl rdi = new RequestsDaoImpl();
	
	public static void recordRequestVerdict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public static void recordGradeVerdict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public static void loadRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String json = null;
		
		try {
			json = rdi.getRequestsJSON();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.write(json);
	}

}
