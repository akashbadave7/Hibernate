package com.bridgeit.Controller;

import javax.servlet.http.HttpSession;

import com.bridgeit.Model.UserDetails;

public class Validation 
{
	boolean signUpValidator(UserDetails user, HttpSession session) 
	{
		boolean isValid=true;
		String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,3}$";
		String  mobilePattern="^((\\+)?(\\d{2}[-]))?(\\d{10})?$";
		String namePattern="^[a-zA-Z\\s]*$";
		if(!user.getName().matches(namePattern))
		{
			session.setAttribute("error", "Name can not be number");
			isValid=false;
		}
		else if(!user.getEmail().matches(emailPattern))
		{
			session.setAttribute("error", "Enter valid email");
			isValid=false;
		}
		else if(!user.getMobile().matches(mobilePattern))
		{
			session.setAttribute("error", "Enter valid mobile number");
			isValid=false;
		}
		else if(user.getPassword().length()<8)
		{
			session.setAttribute("error", "Password length should be minimun 8 character.");
			isValid=false;
		}
		else
		{
			isValid=true;
		}
		return isValid;
	}
}
