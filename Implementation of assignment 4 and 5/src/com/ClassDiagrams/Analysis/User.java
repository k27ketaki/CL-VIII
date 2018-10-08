package com.ClassDiagrams.Analysis;

public abstract class User
{
	private int ID;
	private String name, email, password;
	private boolean loggedIn;
    abstract boolean login(String username, String password);
    abstract void logout();
    abstract int getID();
    abstract String getName();
    abstract void setName();
    abstract String getEmail();
    abstract void setEmail();
    abstract void setPassword();
    abstract boolean isLoggedIn();
}