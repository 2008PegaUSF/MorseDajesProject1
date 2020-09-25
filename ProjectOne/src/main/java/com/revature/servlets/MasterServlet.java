package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
<<<<<<< HEAD
=======
import javax.servlet.annotation.MultipartConfig;
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.RequestHelper;

<<<<<<< HEAD
=======
@MultipartConfig
>>>>>>> a6f2a7d9ee2719c128f0124fc16f63db00bdd600
public class MasterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6520317557229175093L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestHelper.process(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestHelper.process(request,response);
	}
}
