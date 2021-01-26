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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String user = (String) session.getAttribute("user");
		String email = request.getParameter("email");
		
		if(user.equals("student"))
		{
			String address = request.getParameter("address");
			String mobile = request.getParameter("mobile");
			String father_name = request.getParameter("father_name");
			String fOccupation = request.getParameter("fOccupation");
			String mother_name = request.getParameter("mother_name");
			String mOccupation = request.getParameter("mOccupation");
			try
			{
				ConnectionDB.getConnection();Statement st = ConnectionDB.con.createStatement();
				st.executeUpdate("UPDATE studentinfo SET cAddress='"+address+"',mobile='"+mobile+"',father_name='"+father_name+"',fOccupation='"+fOccupation+"',mother_name='"+mother_name+"',mOccupation='"+mOccupation+"' WHERE email='"+email+"'");
				response.sendRedirect("information.jsp?InformationUpdated");
				
			}
			catch(SQLException s){
				System.out.println(s);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else if(user.equals("teacher"))
		{
			
		}
	}

}
