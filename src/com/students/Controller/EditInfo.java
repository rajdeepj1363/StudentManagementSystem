package com.students.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.students.sql.ConnectionDB;

/**
 * Servlet implementation class EditInfo
 */
@WebServlet("/editInfo")
public class EditInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected boolean StudentEditInfo(String address,String mobile,String father_name,String fOccupation,String mother_name,String mOccupation,String email)
	{
		
		try
		{
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			st.executeUpdate("UPDATE studentinfo SET cAddress='"+address+"',mobile='"+mobile+"',father_name='"+father_name+"',fOccupation='"+fOccupation+"',mother_name='"+mother_name+"',mOccupation='"+mOccupation+"' WHERE email='"+email+"'");
			return true;
			
			
		}
		catch(SQLException s){
			System.out.println(s);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	protected boolean TeacherEditInfo(String address,String mobile,String qualification,String email)
	{
		
		try
		{
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			System.out.print("UNAME: "+email);
			st.executeUpdate("UPDATE teachers SET address='"+address+"',mobile='"+mobile+"',qualification='"+qualification+"' WHERE uname='"+email+"'");
			return true;
			
			
		}
		catch(SQLException s){
			System.out.println(s);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			HttpSession session = request.getSession(true);
			String user = (String) session.getAttribute("user");
			
			if(user.equals("student"))
			{
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String mobile = request.getParameter("mobile");
				String father_name = request.getParameter("father_name");
				String fOccupation = request.getParameter("fOccupation");
				String mother_name = request.getParameter("mother_name");
				String mOccupation = request.getParameter("mOccupation");
				boolean result = StudentEditInfo(address,mobile,father_name,fOccupation,mother_name,mOccupation,email);
				if(result == true)
				{
					response.sendRedirect("information.jsp?InformationUpdated");
				}
				else
				{
					response.sendRedirect("information.jsp?error");
				}
				
			}
			if(user.equals("teacher"))
			{
				String address = request.getParameter("address");
				String mobile = request.getParameter("mobile");
				String qualification = request.getParameter("qualification");
				String email = request.getParameter("uname");
				boolean result = TeacherEditInfo(address,mobile,qualification,email);
				if(result == true)
				{
					response.sendRedirect("information_t.jsp?InformationUpdated");
				}
				else
				{
					response.sendRedirect("information_t.jsp?error");
				}
			}
			
			
		
		
	}

}
