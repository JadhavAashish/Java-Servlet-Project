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

@WebServlet("/updateCat")
public class UpdateCategory extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("categoryId"));
		String name = request.getParameter("cname");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Profile</title>");
		out.println("<link rel='stylesheet' href='CSS/style.css'/>");
		out.println("</head>");
		out.println("<body>");

		RequestDispatcher r = request.getRequestDispatcher("admindashboard.html");
		r.include(request, response);
		out.println("<br>");
		out.println("<form name='frm' action='' method='GET'>");
		out.println("<center>");
		out.println("<h2>Update Category</h2><br>");
		out.println("<input type='hidden' name='categoryId' value='" + id + "' ><br>");
		out.println("<input type='text' name='cname' value='" + name + "' ><br>");
		out.println("<input type='submit' name='s' value='Update'>");
		out.println("</center>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

		String btn = request.getParameter("s");
		if (btn != null) 
		{
			CategoryModel cm = new CategoryModel();
			cm.setId(id);
			cm.setName(name);
			CategoryService cs = new CategoryServiceImpl();
			boolean b = cs.getUpdated(cm);
			if (b) 
			{
				r = request.getRequestDispatcher("viewcategory");
				r.forward(request, response);
			} 
			else 
			{
				out.println("<center><h3>Category Not updated.....</h3></center>");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
