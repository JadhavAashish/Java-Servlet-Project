package org.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.notice.model.CategoryModel;
import org.notice.service.CategoryService;
import org.notice.service.CategoryServiceImpl;

/**
 * Servlet implementation class NewCategory
 */
@WebServlet("/newCategory")
public class NewCategory extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Profile</title>");
		out.println("<link rel='stylesheet' href='CSS/style.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		RequestDispatcher r=request.getRequestDispatcher("admindashboard.html");
		r.include(request, response);
		out.println("<br>");
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<center>");
		out.println("<h2>Add New Category</h2><br>");
		out.println("<input type='text' name='name' value='' ><br>");
		out.println("<input type='submit' name='s' value='Add New Category'>");
		out.println("</center>");
		out.println("</form>");		
		out.println("</body>");
		out.println("</html>");
		
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String name=request.getParameter("name");
			CategoryModel model=new CategoryModel();
			model.setName(name);
			
			CategoryService cs = new CategoryServiceImpl();
			boolean b=cs.isAddCategory(model);
			if(b)
			{
				out.println("<center><h3>New Category Added</h3></center>");
			}
			else
			{
				out.println("<center><h3>Category Not Added</h3></center>");
			}
		}
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
