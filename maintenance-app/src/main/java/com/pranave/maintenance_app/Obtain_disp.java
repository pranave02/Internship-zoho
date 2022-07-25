package com.pranave.maintenance_app;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Obtain_disp
 */
public class Obtain_disp extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int aid = Integer.parseInt(request.getParameter("aid"));
		
		test_resource t = new test_resource();
		
		request.setAttribute("val1",t.get_valuesTests(aid));
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		rd.forward(request, response);
			
		
	}


}
