package com.students.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.students.sql.ConnectionDB;

/**
 * Servlet implementation class EditInformation
 */
@WebServlet("/EditUserInfo")
public class EditInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String function = request.getParameter("function");
		if(function.equals("editSearch"))
		{
			System.out.println("Inside Edit");
			String email = request.getParameter("email");
			
			String user = request.getParameter("user");
			if(user.equals("student"))
			{
				try{
					
					ConnectionDB.getConnection();
					
					Statement st = ConnectionDB.con.createStatement();
					
					ResultSet result = st.executeQuery("SELECT * FROM studentinfo WHERE email='"+email+"'");
					request.setAttribute("result", result);
					RequestDispatcher rq = request.getRequestDispatcher("/EditInfo.jsp");
					
					rq.forward(request,response);
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
			else if(user.equals("teacher"))
			{
				try{
					System.out.println("TEACHER");
					ConnectionDB.getConnection();
					
					Statement st = ConnectionDB.con.createStatement();
					ResultSet result = st.executeQuery("SELECT * FROM teachers WHERE uname='"+email+"'");
					request.setAttribute("result", result);
					RequestDispatcher rq = request.getRequestDispatcher("/EditInfo.jsp");
					
					rq.forward(request,response);
					
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
		if(function.equals("editAction"))
		{
			String user = request.getParameter("user");
			if(user.equals("student")){
				String title = request.getParameter("title");
				String fname = request.getParameter("fname");
				String mname = request.getParameter("mname");
				String lname = request.getParameter("lname");
				String gender = request.getParameter("gender");
				String mobile = request.getParameter("mobile");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String cAddress = request.getParameter("cAddress");
				String pAddress= request.getParameter("pAddress");
				String dob = request.getParameter("dob");
				String pob = request.getParameter("pob");
				String marital_status = request.getParameter("marital_status");
				String father_name = request.getParameter("father_name");
				String fOccupation = request.getParameter("fOccupation");
				String mother_name = request.getParameter("mother_name");
				String mOccupation = request.getParameter("mOccupation");
				String parent_phone = request.getParameter("parent_phone");
				String caste_category = request.getParameter("caste_category");
				String sub_caste = request.getParameter("sub_caste");
				String nationality = request.getParameter("nationality");
				String religion = request.getParameter("religion");
				String handicap = request.getParameter("handicap");
				HttpSession session = request.getSession();
				String oldEmail = (String)session.getAttribute("oldEmail");
				System.out.println("Session Value:"+oldEmail);
				try{
					ConnectionDB.getConnection();
					Statement st = ConnectionDB.con.createStatement();
					st.executeUpdate("UPDATE studentinfo SET title='"+title+"',fname='"+fname+"',mname='"+mname+"',lname='"+lname+"',gender='"+gender+"',mobile='"+mobile+"',phone='"+phone+"',email='"+email+"',cAddress='"+cAddress+"',pAddress='"+pAddress+"',dob='"+dob+"',pob='"+pob+"',father_name='"+father_name+"',fOccupation='"+fOccupation+"',mother_name='"+mother_name+"',mOccupation='"+mOccupation+"',parent_phone='"+parent_phone+"',caste_category='"+caste_category+"',sub_caste='"+sub_caste+"',nationality='"+nationality+"',religion='"+religion+"',handicap='"+handicap+"' WHERE email='"+oldEmail+"'");
					/*,address='"+address+"',mobile='"+mobile+"',dob='"+dob+"',qualification='"+qualification+"',designation='"+designation+"',classTeacher='"+classTeacher+"',teachingDivisions='"+teachingDivisions+"',teachingSubjects='"+teachingSubjects+"',uname='"+uname+"'*/
					response.sendRedirect("dashboardAdmin.jsp?informationupdate=success");
				}
				catch(SQLException s)
				{
					s.printStackTrace();
				}
				catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
			if(user.equals("teacher"))
			{
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String mobile = request.getParameter("mobile");
				String dob = request.getParameter("dob");
				String qualification = request.getParameter("qualification");
				String designation = request.getParameter("designation");
				String classTeacher = request.getParameter("classTeacher");
				String teachingDivisions = request.getParameter("teachingDivisions");
				String teachingSubjects = request.getParameter("teachingSubjects");
				String uname = request.getParameter("uname");
				HttpSession session = request.getSession();
				String oldEmail = (String)session.getAttribute("oldEmail");
				System.out.println("Session Value:"+oldEmail);
				try{
					ConnectionDB.getConnection();
					Statement st = ConnectionDB.con.createStatement();
					st.executeUpdate("UPDATE teachers SET name='"+name+"',address='"+address+"',mobile='"+mobile+"',dob='"+dob+"',qualification='"+qualification+"',designation='"+designation+"',classTeacher='"+classTeacher+"',teachingDivisions='"+teachingDivisions+"',teachingSubjects='"+teachingSubjects+"',uname='"+uname+"' WHERE uname='"+oldEmail+"'");
					/*,address='"+address+"',mobile='"+mobile+"',dob='"+dob+"',qualification='"+qualification+"',designation='"+designation+"',classTeacher='"+classTeacher+"',teachingDivisions='"+teachingDivisions+"',teachingSubjects='"+teachingSubjects+"',uname='"+uname+"'*/
					response.sendRedirect("dashboardAdmin.jsp?informationupdate=success");
				}
				catch(SQLException s)
				{
					s.printStackTrace();
				}
				catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

}
