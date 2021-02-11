package com.students.Controller;

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

import com.students.POJO.AdmissionInfo;
import com.students.sql.*;
/**
 * Servlet implementation class FetchAdmissionInfo
 */
@WebServlet("/ViewAdmissionDetails")
public class FetchAdmissionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	String fetchedEmail = "";
	boolean RegisteredUser = false;
	protected AdmissionInfo FetchAdmissionInfo(String email)
	{
		
		try
		{
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM admissiondata");
			while(res.next())
			{
				fetchedEmail = res.getString("email");
				if(fetchedEmail.equals(email))
				{
					RegisteredUser = true;
					break;
				}
			}
			if(RegisteredUser == false)
			{
				return null;
				
			}
			else
			{
				res = st.executeQuery("SELECT * FROM admissiondata WHERE email='"+fetchedEmail+"'");
				while(res.next())
				{
					AdmissionInfo student = new AdmissionInfo();
					student.setTitle(res.getString("title"));
					student.setFname(res.getString("fname"));
					student.setMname(res.getString("mname"));
					student.setLname(res.getString("lname"));
					student.setGender(res.getString("gender"));
					student.setMobile(res.getString("mobile"));
					student.setPhone(res.getString("phone"));
					student.setEmail(res.getString("email"));
					student.setDob(res.getString("dob"));
					student.setPob(res.getString("pob"));
					student.setMarital_status(res.getString("marital_status"));
					student.setFather_name(res.getString("father_name"));
					student.setfOccupation(res.getString("fOccupation"));
					student.setMother_name(res.getString("mother_name"));
					student.setmOccupation(res.getString("mOccupation"));
					student.setParentPhone(res.getString("parent_phone"));
					student.setCaste_category(res.getString("caste_category"));
					student.setSub_caste(res.getString("sub_caste"));
					student.setNationality(res.getString("nationality"));
					student.setReligion(res.getString("religion"));
					student.setHandicap(res.getString("handicap"));
					student.setUp_aadhar(res.getString("aadhar_file"));
					student.setUp_PAN(res.getString("pan_file"));
					student.setUp_tenth(res.getString("tenth_marksheet"));
					student.setUp_twelve(res.getString("twelveth_marksheet"));
					return student;
					
				}
				
			}
		}
			catch(SQLException e)
			{
				System.out.println(e);
			} 
			catch (ClassNotFoundException e) 
			{
				
				e.printStackTrace();
			}
		return null;
		}
			
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String email = request.getParameter("candidate_email");
		AdmissionInfo result = FetchAdmissionInfo(email);
		if(result == null)
		{
			out.print("<script type='text/javascript'>alert('Not such user found')</script>");
			response.sendRedirect("dashboardAdmin.jsp?invalidAdmission");
		}
		else
		{
			request.setAttribute("admissionInfo", result);
			RequestDispatcher req = request.getRequestDispatcher("admissionInfo.jsp");
			req.forward(request,response);
		}
		
	}

}
