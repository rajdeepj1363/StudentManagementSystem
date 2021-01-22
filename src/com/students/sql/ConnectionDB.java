package com.students.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public static Connection con;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String URL="jdbc:mysql://localhost:3306/studentms";
			Class.forName(driver);
			
			if(con==null)
			{
				con= DriverManager.getConnection(URL,"root","root");
				System.out.println("Connected");
			}
			return con;
		}
		catch(Exception e)
		{
			System.out.println("Error while connecting to sql");
		}
		return con;
		
	}
	
	public static void closeConnection(Connection con)throws SQLException
	{
		if(con!=null)
		{
			con.close();
			System.out.println("Connection Terminated");
		}
		
	}
}
