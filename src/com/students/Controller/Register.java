package com.students.Controller;


import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.students.sql.ConnectionDB;

import java.sql.*;
import java.util.Iterator;
/**
 * Servlet implementation class Register
 */

@WebServlet("/admission")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //public static ConnectionDB con = (ConnectionDB) ConnectionDB.con;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String[] formFields = {"title","fname","mname","lname","gender","mobile","phone","email","dob","pob","marital_status","father_name","fOccupation","mother_name","mOccupation","parent_phone","caste_category","sub_caste","nationality","religion","handicap"};
		String[] userFormFields = new String[25];
		/*String title = request.getParameter("title");
		String fname = request.getParameter("fname");
		String mname = request.getParameter("mname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String mobile = request.getParameter("mobile");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String pob = request.getParameter("pob");
		String marital_status = request.getParameter("marital_status");
		String father_name = request.getParameter("father_name");
		String father_occupation = request.getParameter("father_occupation");
		String mother_name = request.getParameter("mother_name");
		String mother_occupation = request.getParameter("mother_occupation");
		String parent_phone = request.getParameter("parent_phone");
		String caste_category = request.getParameter("caste_category");
		String sub_caste = request.getParameter("sub_caste");
		String nationality = request.getParameter("nationality");
		String religion = request.getParameter("religion");
		String handicap = request.getParameter("handicap");
		String aadhar = request.getParameter("up_aadhar");
		System.out.println("File name: "+aadhar);
		String pan = request.getParameter("up_PAN");
		String tenth = request.getParameter("up_tenth");
		String twelveth = request.getParameter("up_twelve");*/
		
		try{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
			if(!isMultipartContent)
			{
				System.out.println("No files found");
				return;
			}
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			List <FileItem> fields = upload.parseRequest(request);
			Iterator <FileItem> it = fields.iterator();
			if(!it.hasNext())
			{
				System.out.println("Iterator not found anything");
				return;
			}
			int i=0;
			int flag = 0;
			
			while(it.hasNext())
			{
				FileItem fileItem = it.next();
				if(i<21 && flag !=1)
				{
					userFormFields[i] = fileItem.getString();
				}
				else
				{
					Random rand = new Random();
					int randomNum = rand.nextInt(9999999);
					String uniqName = userFormFields[1]+String.valueOf(randomNum)+userFormFields[3];
					String originalName = fileItem.getName();
					flag = 1;
					if(fileItem.getSize()>0)
					{
						if(i == 21)
						{
							uniqName = uniqName+"aadhar"+".jpg";
							fileItem.write(new File("C:\\Users\\Rajdeep\\workspace\\StudentManagementSystem\\WebContent\\uploaded_files\\aadhar\\"+uniqName));
							userFormFields[21] = uniqName;
						}
						if(i == 22)
						{
							uniqName = uniqName+"PAN"+".jpg";
							fileItem.write(new File("C:\\Users\\Rajdeep\\workspace\\StudentManagementSystem\\WebContent\\uploaded_files\\pan\\"+uniqName));
							userFormFields[22] = uniqName;
						}
						if(i == 23)
						{
							uniqName = uniqName+"10th"+".jpg";
							fileItem.write(new File("C:\\Users\\Rajdeep\\workspace\\StudentManagementSystem\\WebContent\\uploaded_files\\10thMarksheet\\"+uniqName));
							userFormFields[23] = uniqName;
						}
						if(i == 24)
						{
							uniqName = uniqName+"12th"+".jpg";
							fileItem.write(new File("C:\\Users\\Rajdeep\\workspace\\StudentManagementSystem\\WebContent\\uploaded_files\\12thMarksheet\\"+uniqName));
							userFormFields[24] = uniqName;
						}
						
					}
				}
				
				i++;
			}
			System.out.println("Info: \n"+userFormFields);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try {
			ConnectionDB.getConnection();
			Statement stmt = null;
			String sql = "INSERT INTO admissiondata(title,fname,mname,lname,gender,mobile,phone,email,dob,pob,marital_status,father_name,fOccupation,mother_name,mOccupation,parent_phone,caste_category,sub_caste,nationality,religion,handicap,aadhar_file,pan_file,tenth_marksheet,twelveth_marksheet) VALUES('"+userFormFields[0]+"','"+userFormFields[1]+"','"+userFormFields[2]+"','"+userFormFields[3]+"','"+userFormFields[4]+"','"+userFormFields[5]+"','"+userFormFields[6]+"','"+userFormFields[7]+"','"+userFormFields[8]+"','"+userFormFields[9]+"','"+userFormFields[10]+"','"+userFormFields[11]+"','"+userFormFields[12]+"','"+userFormFields[13]+"','"+userFormFields[14]+"','"+userFormFields[15]+"','"+userFormFields[16]+"','"+userFormFields[17]+"','"+userFormFields[18]+"','"+userFormFields[19]+"','"+userFormFields[20]+"','"+userFormFields[21]+"','"+userFormFields[22]+"','"+userFormFields[23]+"','"+userFormFields[24]+"')";
			stmt = ConnectionDB.con.createStatement();
			stmt.executeUpdate(sql);
		
				
				System.out.println("Insertion Done!");
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?admission=1");
                dispatcher.forward(request, response);
			}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
