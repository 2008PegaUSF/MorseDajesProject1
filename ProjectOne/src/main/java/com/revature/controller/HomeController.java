package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {
	public static void getHomePage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Welcome Home");
	}
}
