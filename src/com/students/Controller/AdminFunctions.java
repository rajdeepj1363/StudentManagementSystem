package com.students.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.students.sql.ConnectionDB;

/**
 * Servlet implementation class AdminFunctions
 */
@WebServlet("/AdminFunctions")
public class AdminFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String function = request.getParameter("function");
		if(function.equals("del")) // Delete Data from Database
		{
			String email = request.getParameter("email");
			String user = request.getParameter("user");
			if(user.equals("student"))
			{
				try{
					ConnectionDB.getConnection();
					Statement st = ConnectionDB.con.createStatement();
					st.executeUpdate("DELETE FROM studentinfo WHERE email='"+email+"'");
					st.executeUpdate("DELETE FROM studentcreds WHERE email='"+email+"'");
					System.out.println("Student has been deleted!");
					response.sendRedirect("dashboardAdmin.jsp?StudentDelete=success");
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
			else if(user.equals("teacher"))
			{
				try{
					ConnectionDB.getConnection();
					Statement st = ConnectionDB.con.createStatement();
					st.executeUpdate("DELETE FROM teachers WHERE uname='"+email+"'");
					System.out.println("Teacher has been deleted!");
					response.sendRedirect("dashboardAdmin.jsp?TeacherDelete=success");
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
		
	}

}
