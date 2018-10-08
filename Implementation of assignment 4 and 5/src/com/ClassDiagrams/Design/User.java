package com.ClassDiagrams.Design;

import java.util.Scanner;

public class User
{
	protected int ID;
	protected String name, email, password;
	protected boolean loggedIn;
	boolean login(String username, String password)
	{
		if(username == email && password == this.password)
		{
			loggedIn = true;
			return true;
		}
		else
			return false;
	}
	void logout()
	{
		loggedIn = false;
	}
	int getID()
	{
		if(isLoggedIn())
			return ID;
		return -1;
	}
	String getName()
	{
		if(isLoggedIn())
			return name;
		return "\0";
	}
	void setName(String newName)
	{
		if(isLoggedIn())
			name = newName;
	}
	String getEmail()
	{
		if(isLoggedIn())
			return email;
		return "\0";
	}
	void setEmail(String newEmail)
	{
		if(isLoggedIn())
			email = newEmail;
	}
	void setPassword(String newPassword)
	{
		if(isLoggedIn())
			password = newPassword;
	}
	boolean isLoggedIn()
	{
		return loggedIn;
	}
}