package com.students.Controller;

import com.students.POJO.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


import javax.servlet.http.HttpServlet;

import com.students.sql.ConnectionDB;
/**
 * Servlet implementation class FetchInfo
 */
@WebServlet("/FetchInfo")
public class FetchInfo {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public static StudentInfo fetchStudentInfo(String email)
	{
		
		try{
			ConnectionDB.getConnection();
			System.out.println("I got the connection!");
			Statement statement = ConnectionDB.con.createStatement();
			
			ResultSet result = statement.executeQuery("SELECT * FROM studentinfo WHERE email ='"+email+"' LIMIT 1");
			StudentInfo student = new StudentInfo();
			System.out.println("Student obj created");
			while(result.next())
			{

				student.setName(result.getString("fname")+" "+result.getString("mname")+" "+result.getString("lname"));
				student.setAddress(result.getString("cAddress"));
				student.setEmail(result.getString("email"));
				student.setPhone(result.getString("mobile"));
				student.setDob(result.getString("dob"));
				student.setFatherName(result.getString("father_name"));
				student.setfOccupation(result.getString("fOccupation"));
				student.setMotherName(result.getString("mother_name"));
				student.setmOccupation(result.getString("mOccupation"));
				student.setParentPhone(result.getString("parent_phone"));
				student.setPRN(result.getString("PRN"));
				student.setCurrentSTD(result.getString("CURR_YEAR")+" "+result.getString("CURR_DIV"));
				student.setRollNo(result.getString("CURR_ROLL"));
				
			}
			System.out.println(student);
			return student;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("driver not found at fetchinfo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		}
		
		public static TeacherInfo fetchTeacherInfo(String email)
		{
				try{
					ConnectionDB.getConnection();
					System.out.println("I got the connection!");
					Statement statement = ConnectionDB.con.createStatement();
					ResultSet result = statement.executeQuery("SELECT * FROM teachers WHERE uname ='"+email+"' LIMIT 1");
					TeacherInfo teacher = new TeacherInfo();
					System.out.println("Teacher obj created");
					while(result.next())
					{
	
						teacher.setName(result.getString("name"));
						teacher.setAddress(result.getString("address"));
						teacher.setUname(result.getString("uname"));
						teacher.setMobile(result.getString("mobile"));
						teacher.setDob(result.getString("dob"));
						teacher.setQualification(result.getString("qualification"));
						teacher.setDesignation(result.getString("designation"));
						teacher.setClassTeacher(result.getString("classTeacher"));
						teacher.setTeachingDivisions(result.getString("teachingDivisions"));
						teacher.setTeachingSubjects(result.getString("teachingSubjects"));
						
						
					}
					System.out.println(teacher);
					return teacher;
				}
				catch(SQLException s)
				{
					s.printStackTrace();
				}
				catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				return null;
			
		}
			
			
			
			
		
		
	}

