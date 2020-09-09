package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupervisorController {

	public static void recordRequestVerdict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in record request verdict in supervisor controller");
		
	}
	
	public static void recordGradeVerdict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in record grade verdict in supervisor controller");
	}
}
