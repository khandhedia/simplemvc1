package com.nirav.mvc.service;

public class LoginService {
	
	public boolean validateLogin(String name, String password)
	{
		if("abc".equals(name) && "def".equals(password))
		{
			return true;
		}
		
		return false;
		
		
	}

}
