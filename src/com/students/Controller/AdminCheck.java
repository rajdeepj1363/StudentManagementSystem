package com.students.Controller;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import javax.servlet.http.HttpSession;

import com.students.sql.*;
/**
 * Servlet implementation class AdminCheck
 */
@WebServlet("/checkAdmin")
public class AdminCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	String fetchedUsername = "";
	String fetchedPassword = "";
	
	protected boolean checkCredentials(String username,String password)
	{
		
		boolean login = false;
		try
		{
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM admin");
			while(result.next())
			{
				fetchedUsername = result.getString("username");
				fetchedPassword = result.getString("pwd");
				if(fetchedUsername.equals(username) && fetchedPassword.equals(password))
				{
					login = true;
					break;
				}
			}
			if(login == false)
			{
				System.out.println("Invalid Credentials");
				return false;
				
			}
			else
			{
				return true;
				
			}
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException s)
		{
			System.out.println(s);
		}
		return false;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("adminUsername");
		String password = request.getParameter("adminPwd");
		boolean result = checkCredentials(username,password);
		if(result == true)
		{
			HttpSession session = request.getSession();
			session.setAttribute("AdminUsername", fetchedUsername);
			session.setAttribute("AdminPassword", fetchedPassword);
			response.sendRedirect("dashboardAdmin.jsp?login=success");
		}
		else
		{
			response.sendRedirect("index.jsp?invalidcredentials");
		}
		
	}

}
