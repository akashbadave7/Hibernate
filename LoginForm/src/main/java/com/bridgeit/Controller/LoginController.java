package com.bridgeit.Controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.bridgeit.DAO.DataBase;
import com.bridgeit.Model.UserDetails;


/**
 * Servlet implementation class HomePage
 */
//@WebServlet("/HomePage")
public class LoginController extends HttpServlet 
{
	static Logger logger = Logger.getLogger(LoginController.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataBase database = new DataBase();
		BasicConfigurator.configure();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail(email);
		userDetails.setPassword(password);
		
		userDetails = database.getEmail(userDetails);
		out.print(userDetails.getEmail()+" "+userDetails.getMobile()+" "+userDetails.getName()+" "+userDetails.getPassword());
		if(userDetails.isValid())
		{
			
			logger.info("Login Successfull");
			HttpSession session = request.getSession(true); 
			session.setAttribute("email",email);
			session.setAttribute("name", userDetails.getName());
			response.sendRedirect(response.encodeRedirectURL("homepage")); //logged-in page 
		}
		else 
		{
			logger.warn("Login Failed");
			HttpSession session = request.getSession();
			session.setAttribute("error", "Wrong username or password");
		    
			response.sendRedirect("login");
			/*out.println("<font color=red>Either user name or password is wrong.</font>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login");
			requestDispatcher.include(request, response);*/
		}
			
	}

}
