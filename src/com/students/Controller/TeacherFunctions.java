package com.students.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.students.sql.*;

/**
 * Servlet implementation class TeacherFunctions
 */
@WebServlet("/TeacherFunction")
public class TeacherFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String function = request.getParameter("function");
		if(function.equals("InsertAttendance"))
		{
			String email = request.getParameter("student_name");
			String total_att = request.getParameter("totalLectures");
			String attended_att = request.getParameter("attendedLectures");
			try
			{
				ConnectionDB.getConnection();
				Statement st = ConnectionDB.con.createStatement();
				st.executeUpdate("UPDATE attendance SET totalLec='"+total_att+"',attendedLec='"+attended_att+"' WHERE email='"+email+"'");
				response.sendRedirect("attendance.jsp?"+email+"=updated");
				
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(SQLException s)
			{
				s.printStackTrace();
			}
		}
	}

}
