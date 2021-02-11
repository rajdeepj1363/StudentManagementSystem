package com.students.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.students.sql.ConnectionDB;

public class GetStudentList {
	public static ResultSet StudentList(String Course,String Year,String Div)
	{
		try
		{
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM studentinfo WHERE COURSE='"+Course+"' AND CURR_YEAR='"+Year+"' AND CURR_DIV='"+Div+"'");
			return result;
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException s)
		{
			s.printStackTrace();
		}
		return null;
		
	}
}
