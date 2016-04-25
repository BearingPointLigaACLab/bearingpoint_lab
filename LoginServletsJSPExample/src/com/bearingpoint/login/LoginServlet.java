package com.bearingpoint.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String wrong = null;
		LinkedHashMap<String, String> users = new LinkedHashMap<String , String>();
		users.put("andreimihut" , "123456");
		users.put("dianastoian" , "abcd");
		users.put("ionpanfilii" , "panfilii");
		users.put("meme94" , "123abc");
		users.put("balog96" , "1100");
		users.put("useruser" , "paswword");
		ArrayList<String> usernames = new ArrayList<String>(users.keySet());
		ArrayList<String> passwords = new ArrayList<String>(users.values());
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		request.setAttribute("wrong", wrong);
		for(int i = 0 ; i <users.size() ; i++)
		{
			if(usernames.get(i).equals(username) && passwords.get(i).equals(password))
			{
				request.setAttribute("username", username);
				getServletContext().getRequestDispatcher("/ClientPage.jsp").forward(request, response);
				return;
			}
		}
		wrong = "Invalid email and/or password. Please try again.";
		request.setAttribute("wrong", wrong);
		getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
	}

}
