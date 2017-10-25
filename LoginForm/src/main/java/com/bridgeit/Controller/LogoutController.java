package com.bridgeit.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class LogoutController
 */
//@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	static Logger logger = Logger.getLogger(LogoutController.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		HttpSession session = request.getSession(true);
		
		// session.setAttribute("user", null);
		session.removeAttribute("email");
		session.getMaxInactiveInterval();
		session.invalidate();
		logger.info("Successfully logout");
		response.sendRedirect("login");
	}

}
