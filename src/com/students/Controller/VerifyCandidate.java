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

import com.students.sql.*;
/**
 * Servlet implementation class VerifyCandidate
 */
@WebServlet("/verifyCandidate")
public class VerifyCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("candidate_email");
		System.out.println("Candidate's Email: "+ email);
		try
		{
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			st.executeUpdate("UPDATE admissiondata SET verification = 'DONE' WHERE email='"+email+"'");
			response.sendRedirect("dashboardAdmin.jsp?"+email+"=verified");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException s)
		{
			System.out.println(s);
		}
	}

}
