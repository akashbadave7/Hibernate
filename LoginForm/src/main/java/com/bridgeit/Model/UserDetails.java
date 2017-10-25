package com.bridgeit.Model;

import javax.persistence.Embeddable;

import javax.persistence.GeneratedValue;

import javax.persistence.Table;

@Embeddable
@Table(name="registration")
public class UserDetails 
{
	
	@GeneratedValue
	private String name,email,password,mobile;
	private boolean valid;
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setMobile(String mobile)
	{
		this.mobile= mobile;
	}
	public String getMobile()
	{
		return mobile;
	}
	public boolean isValid() 
	{	
		return valid;
	}
	public void setValid(boolean valid) 
	{
		this.valid=valid;
		
	}
}
