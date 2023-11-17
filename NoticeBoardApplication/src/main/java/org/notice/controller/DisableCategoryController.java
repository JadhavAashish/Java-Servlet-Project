package org.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.notice.service.CategoryService;
import org.notice.service.CategoryServiceImpl;

@WebServlet("/disableCat")
public class DisableCategoryController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int catId=Integer.parseInt(request.getParameter("categoryId"));
		
		CategoryService catService=new CategoryServiceImpl();
		boolean b=catService.isDisableCategory(catId);
		if(b)
		{
			RequestDispatcher r=request.getRequestDispatcher("viewcategory");
			r.forward(request, response);
		}
		else
		{
			out.println("<h2>Some Problem is there....</h2>");
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
