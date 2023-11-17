package org.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.notice.model.CategoryModel;
import org.notice.service.CategoryService;
import org.notice.service.CategoryServiceImpl;

@WebServlet("/searchCat")
public class SearchCategory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("catName");
		
		CategoryService catService=new CategoryServiceImpl();
		List<CategoryModel> list=catService.getAllCategoryByName(name);
		out.println("<table border='2' width=70%  align='center'>");
		out.println("<th><tr><td>Category Name</td><td>Update</td><td>Disable</td></tr></th>");
		for(CategoryModel catMod:list)
		{
			out.println("<tr align-item='center'>");
				out.println("<td>"+catMod.getName()+"</td>");
				out.println("<td><a href=''>Update</a></td>");
				out.println("<td><a href='disableCat?categoryId="+catMod.getId()+"'>Disable</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
