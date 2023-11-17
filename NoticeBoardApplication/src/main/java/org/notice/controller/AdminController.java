package org.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.notice.model.LoginModel;
import org.notice.service.AdminService;
import org.notice.service.AdminServiceImpl;

@WebServlet("/adminctrl")
public class AdminController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		LoginModel adminModel=new LoginModel();
		adminModel.setEmail(email);
		adminModel.setPassword(password);
		try
		{
			AdminService adminService=new AdminServiceImpl();
			LoginModel model=adminService.validateAdmin(adminModel);
			if(model!=null)
			{
				HttpSession session=request.getSession(true);
				session.setAttribute("aid", model);
				//out.println(model);
				RequestDispatcher r=request.getRequestDispatcher("admindashboard.html");
				r.forward(request, response);
			}
			else
			{
				RequestDispatcher r=request.getRequestDispatcher("login.html");
				r.include(request, response);
				out.println("Invalid uername and password");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
