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

@WebServlet("/viewprofile")
public class ViewProfile extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession(true);
		LoginModel lp=(LoginModel)session.getAttribute("aid");
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Profile</title>");
		out.println("<link rel='stylesheet' href='CSS/style.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		RequestDispatcher r=request.getRequestDispatcher("admindashboard.html");
		r.include(request, response);
		out.println("<br>");
		out.println("<center>");
		out.println("<h2>Update Profile</h2>");
		out.println("<input type='text' name='name' value='"+lp.getName()+"' ><br>");
		out.println("<input type='text' name='email' value='"+lp.getEmail()+"'><br>");
		out.println("<input type='text' name='contact' value='"+lp.getContact()+"'><br>");
		out.println("<input type='text' name='password' value='"+lp.getPassword()+"'><br>");
		out.println("<input type='submit' name='s' value='Update Profile'>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
