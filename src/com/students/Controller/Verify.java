package com.students.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static java.lang.System.out;
import static javax.swing.JOptionPane.showMessageDialog;







//SQL PACKAGES
import java.sql.*;

import com.students.sql.ConnectionDB;

/**
 * Servlet implementation class Verify
 */
@WebServlet("/verify")
public class Verify extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("email");
		String password = request.getParameter("pwd");
		String user = request.getParameter("student_teacher");
		System.out.println("Email: "+username+"\nPassword: "+password);	
		String fetchedUsername = "";
		String fetchedPassword = "";
		String fetchedName = "";
		boolean Slogin = false;
		boolean Tlogin = false;
		try{
			ConnectionDB.getConnection();
			
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("driver not found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user.equals("student"))
		{
			System.out.println("Entered Student");
			try {
				Statement statement = ConnectionDB.con.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM studentcreds");

								
				while(result.next())
				{	
					fetchedUsername = result.getString("email");
					fetchedPassword = result.getString("passKey");
					fetchedName = result.getString("fname")+" "+result.getString("lname");
						if(fetchedUsername.equals(username) && fetchedPassword.equals(password))
						{
							Slogin = true;
							break;
						}
						
						
				}
				if(Slogin == false)
				{
					response.sendRedirect("index.jsp?InvalidCredentials");
				}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("email", fetchedUsername);
					session.setAttribute("password", fetchedPassword);
					session.setAttribute("user",user);
					session.setAttribute("name",fetchedName);
					response.sendRedirect("dashboard.jsp?LoginSuccessful");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(user.equals("teacher"))
		{
			System.out.println("Entered Teacher");
			try {
				Statement statement = ConnectionDB.con.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM teachers WHERE uname ='"+username+"' AND pwd='"+password+"' LIMIT 1");
				
				while(result.next())
				{
					fetchedUsername = result.getString("uname");
					fetchedPassword = result.getString("pwd");
					fetchedName = result.getString("name");
					if(fetchedUsername.equals(username) && fetchedPassword.equals(password))
					{
						Tlogin = true;
						System.out.println(Tlogin);
						break;
					}
						
						
				}
				if(Tlogin == false)
				{
					response.sendRedirect("index.jsp?InvalidCredentials");
				}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("TeacherEmail", fetchedUsername);
					session.setAttribute("TeacherPassword", fetchedPassword);
					session.setAttribute("user",user);
					session.setAttribute("name",fetchedName);
					
					response.sendRedirect("dashboardTeacher.jsp?LoginSuccess");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
