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
		System.out.println("Email: "+username+"\nPassword: "+password);
		
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
		
		try {
			Statement statement = ConnectionDB.con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM studentcreds WHERE email ='"+username+"' AND passkey='"+password+"' LIMIT 1");
			
			while(result.next())
			{
					
					String email = result.getString("email");
					String pwd = result.getString("passkey");
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					session.setAttribute("password", pwd);
					response.sendRedirect("dashboard.jsp");
					
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
