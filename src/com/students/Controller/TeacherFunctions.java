package com.students.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;



import com.students.sql.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * Servlet implementation class TeacherFunctions
 */
@WebServlet("/TeacherFunction")
public class TeacherFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected boolean insertAttendance(String email,String total_att,String attended_att)
	{
		
		try
		{
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			st.executeUpdate("UPDATE attendance SET totalLec='"+total_att+"',attendedLec='"+attended_att+"' WHERE email='"+email+"'");
			return true;
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException s)
		{
			s.printStackTrace();
		}
		return false;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("student_name");
		String total_att = request.getParameter("totalLectures");
		String attended_att = request.getParameter("attendedLectures");
		boolean result = insertAttendance(email,total_att,attended_att);
		if(result == true)
		{
			response.sendRedirect("attendance.jsp?"+email+"=updated");
		}
		else
		{
			response.sendRedirect("attendance.jsp?"+email+"=failed");
		}
		
			
		
	}

}
