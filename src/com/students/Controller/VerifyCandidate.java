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

import java.util.Random;

import com.students.sql.*;
import com.students.POJO.AdmissionInfo;
/**
 * Servlet implementation class VerifyCandidate
 */
@WebServlet("/verifyCandidate")
public class VerifyCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String password = "";
   protected boolean verifyCandidate(String email,AdmissionInfo student)
   {
	   boolean result = false;
	   
	   
	   try
		{
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			
			
			
			String title = student.getTitle();
			String fname = student.getFname();
			String mname = student.getMname();
			String lname = student.getLname();
			String gender = student.getGender();
			String mobile = student.getMobile();
			String phone = student.getPhone();
			
			String dob = student.getDob();
			String pob = student.getPob();
			String marital_status = student.getMarital_status();
			String father_name = student.getFather_name();
			String father_occupation = student.getfOccupation();
			String mother_name = student.getMother_name();
			String mother_occupation =student.getmOccupation();
			String parent_phone = student.getParentPhone();
			String caste_category = student.getCaste_category();
			String sub_caste = student.getSub_caste();
			String nationality = student.getNationality();
			String religion = student.getReligion();
			String handicap = student.getHandicap();
			String aadhar = student.getUp_aadhar();
			String pan = student.getUp_PAN();
			String tenth = student.getUp_tenth();
			String twelveth =student.getUp_twelve();
			String allotted_year = student.getAllotted_year();
			String allotted_div = student.getAllotted_div();
			String allotted_course = student.getAllotted_course();
			Random rand = new Random();
			String uniq = "PassKey"+String.valueOf(rand.nextInt(999999));
			password = uniq;
			st.executeUpdate("UPDATE admissiondata SET verification = 'DONE' WHERE email='"+email+"'");
			st.executeUpdate("INSERT INTO studentcreds(fname,lname,email,passkey) VALUES('"+fname+"','"+lname+"','"+email+"','"+uniq+"')");
			st.executeUpdate("INSERT INTO studentinfo(title,fname,mname,lname,gender,mobile,phone,email,dob,pob,marital_status,father_name,fOccupation,mother_name,mOccupation,parent_phone,caste_category,sub_caste,nationality,religion,handicap,aadhar,pan,tenthMarksheet,twelvethMarksheet,CURR_YEAR,CURR_DIV,COURSE) VALUES('"+title+"','"+fname+"','"+mname+"','"+lname+"','"+gender+"','"+mobile+"','"+phone+"','"+email+"','"+dob+"','"+pob+"','"+marital_status+"','"+father_name+"','"+father_occupation+"','"+mother_name+"','"+mother_occupation+"','"+parent_phone+"','"+caste_category+"','"+sub_caste+"','"+nationality+"','"+religion+"','"+handicap+"','"+aadhar+"','"+pan+"','"+tenth+"','"+twelveth+"','"+allotted_year+"','"+allotted_div+"','"+allotted_course+"')"); 
			result = true;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException s)
		{
			System.out.println(s);
		}
	   return result;
	   
   }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("candidate_email");
		System.out.println("Candidate's Email: "+ email);
		HttpSession session = request.getSession(true);
		AdmissionInfo student = (AdmissionInfo)session.getAttribute("AdmissionData");
		String allotted_year = request.getParameter("allotted_year");
		String allotted_div = request.getParameter("allotted_div");
		String allotted_course = request.getParameter("allotted_course");
		student.setAllotted_course(allotted_course);
		student.setAllotted_div(allotted_div);
		student.setAllotted_year(allotted_year);
		boolean result = verifyCandidate(email,student);
		if(result == true)
		{
			response.sendRedirect("dashboardAdmin.jsp?"+email+"=verified&passkey="+password);

		}
		else
		{
			response.sendRedirect("dashboardAdmin.jsp?"+email+"=verified&passkey="+password);
		}
		
	}

}
