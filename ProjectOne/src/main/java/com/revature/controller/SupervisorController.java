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
		String verdict = request.getParameter("verdict");
		
		switch (verdict) {
		case "Approve":
			approve(request, response);
			break;
		case "Deny":
			deny(request, response);
			break;
		default:
			System.out.println("INVALID OPTION");
			request.getRequestDispatcher("/pendingRequests.html").forward(request, response);
			break;
		}
	}
	
	public static void recordGradeVerdict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public static void deny(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get User
		HttpSession sesh = request.getSession(false);
		
		int userid = ((Integer) sesh.getAttribute("userid")).intValue();
		
		Users user = null;
		try {
			user = udi.getUserByUserId(userid);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String userType = user.getUsertype();
		
		//Get Submission
		String[] selections = request.getParameterValues("selection");
		int[] requestids = new int[selections.length];
		
		for (int i = 0; i < selections.length; i++) {
			requestids[i] = Integer.parseInt(selections[i]);
		}
		
		switch (userType) {
		case "Direct Supervisor":
			for (int requestid : requestids) {
				try {
					rdi.createDenied(requestid);
					rdi.deletePending(requestid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "Department Head":
			for (int requestid : requestids) {
				try {
					rdi.createDenied(requestid);
					rdi.deleteSupervisorApproved(requestid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "Benefits Coordinator":
			for (int requestid : requestids) {
				try {
					rdi.createDenied(requestid);
					rdi.deleteDepartmentHeadApproved(requestid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			break;
		}
		
		request.getRequestDispatcher("/pendingRequests.html").forward(request, response);
	}
	
	public static void approve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get User
		HttpSession sesh = request.getSession(false);
		
		int userid = ((Integer) sesh.getAttribute("userid")).intValue();
		
		Users user = null;
		try {
			user = udi.getUserByUserId(userid);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String userType = user.getUsertype();
		
		//Get Submission
		String[] selections = request.getParameterValues("selection");
		if (selections != null) {		
			int[] requestids = new int[selections.length];
			
			for (int i = 0; i < selections.length; i++) {
				requestids[i] = Integer.parseInt(selections[i]);
			}
			
			switch (userType) {
			case "Direct Supervisor":
				for (int requestid : requestids) {
					try {
						rdi.createSupervisorApproved(requestid);
						rdi.deletePending(requestid);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				break;
			case "Department Head":
				for (int requestid : requestids) {
					try {
						rdi.createDepartmentHeadApproved(requestid);
						rdi.deleteSupervisorApproved(requestid);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				break;
			case "Benefits Coordinator":
				for (int requestid : requestids) {
					try {
						rdi.createBencoApproved(requestid);
						rdi.deleteDepartmentHeadApproved(requestid);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				break;
			default:
				break;
			}
		}
		
		request.getRequestDispatcher("/pendingRequests.html").forward(request, response);
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