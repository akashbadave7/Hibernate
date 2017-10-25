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
 * Servlet implementation class SignUp
 */
//@WebServlet("/SignUp")
public class SignUpController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(SignUpController.class);
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Validation validate = new Validation();
		BasicConfigurator.configure();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		// JDBC driver name and database URL
		DataBase db = new DataBase();
		UserDetails user = new UserDetails();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(pass);
		user.setMobile(mobile);
		boolean valid = validate.signUpValidator(user,session);
		
		boolean flag = db.insertUser(user);
		if(valid==true)
		{
			if(flag==true)
			{
				logger.info("Signup successfull");
				out.println("Signup successful");
				response.sendRedirect("login");
			}
			else
			{
				logger.warn("User already exits.");
				/*out.println("<font color='red'>Email or phone number alredy exits</font>");
				request.getRequestDispatcher("signup").include(request, response);*/
				
				session.setAttribute("error", "User already exits.");
			    response.sendRedirect("signup");
				return;
			}
		}
		else
		{
			response.sendRedirect("signup");
		}
	}
}
