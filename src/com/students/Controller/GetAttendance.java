package com.students.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.students.sql.*;

public class GetAttendance {

	public static ResultSet getAttendance(String email)
	{
		try
		{
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM attendance WHERE email='"+email+"'");
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
