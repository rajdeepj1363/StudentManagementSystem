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
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
