package com.nirav.mvc.service;

import org.springframework.stereotype.Service;

//Service annotation is added for spring based auto injection

@Service
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
