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
 * Servlet implementation class AddTeacher
 */
@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("teacher_name");
		String mobile = request.getParameter("teacher_mobile");
		String email = request.getParameter("teacher_email");
		String address = request.getParameter("teacher_address");
		String dob = request.getParameter("teacher_dob");
		String qualification = request.getParameter("teacher_qualification");
		String designation = request.getParameter("teacher_designation");
		String classTeacher = request.getParameter("teacher_classTeacher");
		String teachingDivisions = request.getParameter("teacher_divisions");
		String teachingSubjects = request.getParameter("teacher_subjects");
		String pwd = "Passkey"+name.substring(0,4).replaceAll("\\s", "")+mobile.substring(0,5);
		
		try
		{
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			st.executeUpdate("INSERT INTO teachers(name,mobile,address,dob,qualification,designation,classTeacher,teachingDivisions,teachingSubjects,uname,pwd) VALUES('"+name+"','"+mobile+"','"+address+"','"+dob+"','"+qualification+"','"+designation+"','"+classTeacher+"','"+teachingDivisions+"','"+teachingSubjects+"','"+email+"','"+pwd+"')");
			System.out.println("Faculty Updated!");
			response.sendRedirect("dashboardAdmin.jsp?FacultyAdded=success");
		}
		catch(SQLException s)
		{
			System.out.println(s);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
