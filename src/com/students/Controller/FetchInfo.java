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
	
	public static StudentInfo fetchInfo(String email)
	{
		try{
			ConnectionDB.getConnection();
			System.out.println("I got the connection!");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("driver not found at fetchinfo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Statement statement = ConnectionDB.con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM studentinfo WHERE email ='"+email+"' LIMIT 1");
			StudentInfo student = new StudentInfo();
			System.out.println("Student obj created");
			while(result.next())
			{

				student.setName(result.getString("name"));
				student.setAddress(result.getString("address"));
				student.setEmail(result.getString("email"));
				student.setPhone(result.getString("phone"));
				student.setDob(result.getString("dob"));
				student.setAadhar(result.getString("aadhar"));
				student.setFatherName(result.getString("fatherName"));
				student.setfOccupation(result.getString("fOccupation"));
				student.setMotherName(result.getString("motherName"));
				student.setmOccupation(result.getString("mOccupation"));
				student.setParentAdd(result.getString("parentAdd"));
				student.setPRN(result.getString("PRN"));
				student.setCurrentSTD(result.getString("currentSTD"));
				student.setRollNo(result.getString("RollNo"));
				
			}
			System.out.println(student);
			return student;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
