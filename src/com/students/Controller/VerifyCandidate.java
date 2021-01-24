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
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("candidate_email");
		System.out.println("Candidate's Email: "+ email);
		Random rand = new Random();
		String uniq = "PassKey"+String.valueOf(rand.nextInt(999999));
		HttpSession session = request.getSession(true);
		AdmissionInfo student = (AdmissionInfo)session.getAttribute("AdmissionData");
		try
		{
			ConnectionDB.getConnection();
			Statement st = ConnectionDB.con.createStatement();
			
			/*ResultSet res = st.executeQuery("SELECT * FROM admissiondata WHERE email = '"+email+"'");
			res.next();
			String title = res.getString("title");
			String fname = res.getString("fname");
			String mname = res.getString("mname");
			String lname = res.getString("lname");
			String gender = res.getString("gender");
			String mobile = res.getString("mobile");
			String phone = res.getString("phone");
			
			String dob = res.getString("dob");
			String pob = res.getString("pob");
			String marital_status = res.getString("marital_status");
			String father_name = res.getString("father_name");
			String father_occupation = res.getString("fOccupation");
			String mother_name = res.getString("mother_name");
			String mother_occupation =res.getString("mOccupation");
			String parent_phone = res.getString("parent_phone");
			String caste_category = res.getString("caste_category");
			String sub_caste = res.getString("sub_caste");
			String nationality = res.getString("nationality");
			String religion = res.getString("religion");
			String handicap = res.getString("handicap");
			String aadhar = res.getString("aadhar_file");
			String pan = res.getString("pan_file");
			String tenth = res.getString("tenth_marksheet");
			String twelveth = res.getString("twelveth_marksheet");*/
			
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
			
			st.executeUpdate("UPDATE admissiondata SET verification = 'DONE' WHERE email='"+email+"'");
			st.executeUpdate("INSERT INTO studentcreds(fname,lname,email,passkey) VALUES('"+fname+"','"+lname+"','"+email+"','"+uniq+"')");
			st.executeUpdate("INSERT INTO studentinfo(title,fname,mname,lname,gender,mobile,phone,email,dob,pob,marital_status,father_name,fOccupation,mother_name,mOccupation,parent_phone,caste_category,sub_caste,nationality,religion,handicap,aadhar,pan,tenthMarksheet,twelvethMarksheet) VALUES('"+title+"','"+fname+"','"+mname+"','"+lname+"','"+gender+"','"+mobile+"','"+phone+"','"+email+"','"+dob+"','"+pob+"','"+marital_status+"','"+father_name+"','"+father_occupation+"','"+mother_name+"','"+mother_occupation+"','"+parent_phone+"','"+caste_category+"','"+sub_caste+"','"+nationality+"','"+religion+"','"+handicap+"','"+aadhar+"','"+pan+"','"+tenth+"','"+twelveth+"')"); 
			response.sendRedirect("dashboardAdmin.jsp?"+email+"=verified&passkey="+uniq);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException s)
		{
			System.out.println(s);
		}
	}

}
