package org.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.notice.model.CategoryModel;
import org.notice.service.CategoryService;
import org.notice.service.CategoryServiceImpl;

@WebServlet("/viewcategory")
public class ViewAllCategory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher r=request.getRequestDispatcher("admindashboard.html");
		r.include(request, response);
		
		out.println("<br>");
		
		CategoryService catService=new CategoryServiceImpl();
		List<CategoryModel>list=  catService.getAllCategory();
		
		out.println("<html>");
		out.println("<head><title>View All Category</title>");
		out.println("<script src='JS/validate.js' type='text/javascript'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center><input type='text' name='name' value='' placeholder='Search Category' style='width:70%;height:40px;' "
				+ "onkeyup='searchCategory(this.value)'></center>");
		out.println("<br><br>");
		out.println("<div id='d'>");
		out.println("<table border='5' width=70%  align='center'>");
		out.println("<tr><td style='text-align:center;padding:5px;font-weight:bold;'>Category Name</td><td style='text-align:center;padding:5px;font-weight:bold;'>Update</td><td style='text-align:center;padding:5px;font-weight:bold;'>Disable</td></tr>");
		for(CategoryModel catMod:list)
		{
			out.println("<tr>");
			out.println("<td style='text-align:center;padding:5px;'>"+catMod.getName()+"</td>");
			out.println("<td style='text-align:center;padding:5px;'><a href='updateCat?categoryId="+catMod.getId()+"&cname="+catMod.getName()+"'>Update</a></td>");
			out.println("<td style='text-align:center;padding:5px;'><a href='disableCat?categoryId="+catMod.getId()+"'>Disable</a></td>");			  
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
