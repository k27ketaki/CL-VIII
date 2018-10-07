package com.ClassDiagrams.Design;

public class Admin extends User
{
	private String superUserPassword;
	boolean login(String username, String password, String suPassword)
	{
		if(super.login(username, password) == true)
		{
			if(superUserPassword == suPassword)
			{
				loggedIn = true;
				return true;
			}
		}
		return false;
	}
	void setSuperUserPassword(String newSuPassword)
	{
		if(isLoggedIn())
			superUserPassword = newSuPassword;
	}
}