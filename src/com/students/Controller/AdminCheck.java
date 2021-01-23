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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("adminUsername");
		String password = request.getParameter("adminPwd");
		String fetchedUsername = "";
		String fetchedPassword = "";
		boolean login = false;
		try
		{
			ConnectionDB.getConnection();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException s)
		{
			System.out.println(s);
		}
		
		try
		{
			Statement st = ConnectionDB.con.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM admin");
			while(res.next())
			{
				fetchedUsername = res.getString("username");
				fetchedPassword = res.getString("pwd");
				if(fetchedUsername.equals(username) && fetchedPassword.equals(password))
				{
					login = true;
					break;
				}
			}
			if(login == false)
			{
				System.out.println("Invalid Credentials");
				response.sendRedirect("admin.jsp?invalidCredentials");
			}
			HttpSession session = request.getSession();
			session.setAttribute("AdminUsername", fetchedUsername);
			session.setAttribute("AdminPassword", fetchedPassword);
			response.sendRedirect("dashboardAdmin.jsp?login=success");
		}
		catch(SQLException s)
		{
			System.out.println(s);
		}
	}

}
