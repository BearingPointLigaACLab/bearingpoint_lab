package com.bearingpoint.ligaac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.StringUtils;

/**
 * Servlet implementation class MyServletExample
 */
@WebServlet("/myservletexample")
public class MyServletExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServletExample() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		out.println("Hello");

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");

		if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);
		
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);

	}

}
