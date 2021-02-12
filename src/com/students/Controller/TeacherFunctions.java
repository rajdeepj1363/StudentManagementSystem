package com.students.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
       
	protected boolean insertAttendance(String email,String total_att,String attended_att,String name)
	{
		boolean old_entry = false;
		try
		{	
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM attendance");
			while(result.next())
			{
				if(result.getString("email").equals(email))
				{
					old_entry = true;
					break;
				}
			}
			System.out.println("FreshEntry:"+old_entry);
			if(old_entry == true)
			{
				st.executeUpdate("UPDATE attendance SET totalLec='"+total_att+"',attendedLec='"+attended_att+"' WHERE email='"+email+"'");
				return true;
			}
			else
			{
				System.out.println("Entered 2nd if");
				st.executeUpdate("INSERT INTO attendance VALUES('"+email+"','"+name+"','"+total_att+"','"+attended_att+"')");
				return true;
			}
			
			
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
		HttpSession session = request.getSession(true);
		String name = (String)session.getAttribute("name");
		boolean result = insertAttendance(email,total_att,attended_att,name);
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
