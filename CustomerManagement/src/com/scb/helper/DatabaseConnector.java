package com.scb.helper;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector 
{
	static String url="jdbc:postgresql://localhost:5432/scb-omega-2021";
	static String username="postgres";
	static String password="admin";
	static Connection con=null;
	
	public static Connection getConnection()
	{
	
	try
	{
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded Successfully");
		con=DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established Successfully");
	}
	catch (Exception e) 
	{
		// TODO: handle exception
		e.printStackTrace();
	}
	return con;
	}
}
