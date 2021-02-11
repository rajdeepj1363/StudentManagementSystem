package com.students.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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

/**
 * Servlet implementation class ResultUpload
 */
@WebServlet("/ResultUpload")
public class ResultUpload extends HttpServlet {
	String[] userInputs = new String[5];
	private static final long serialVersionUID = 1L;
	
	protected boolean uploadResult()
	{
		boolean result = false;
		try {
			ConnectionDB.getConnection();
			Statement stmt = null;
			String sql = "INSERT INTO results(email,name,exam,date,result) VALUES('"+userInputs[0]+"','"+userInputs[1]+"','"+userInputs[2]+"','"+userInputs[3]+"','"+userInputs[4]+"')";
			stmt = ConnectionDB.con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Result Upload Done!");
			result = true;
			return result;
			}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uniqName = "";
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
			
			while(it.hasNext() && i<5)
			{
				FileItem fileItem = it.next();
				if(i<4 && flag !=1)
				{
					userInputs[i] = fileItem.getString();
				}
				else
				{
					Random rand = new Random();
					int num = rand.nextInt(999999);
					uniqName = userInputs[1]+String.valueOf(num)+userInputs[2]+".pdf";
					System.out.println(uniqName);
					uniqName = uniqName.replaceAll("\\s", "");
					System.out.println(uniqName);
					userInputs[4] = uniqName;
					String originalName = fileItem.getName();
					flag = 1;
					if(fileItem.getSize()>0)
					{
						fileItem.write(new File("C:\\Users\\Rajdeep\\workspace\\StudentManagementSystem\\WebContent\\public\\uploads\\results\\"+userInputs[4]));
						
					}
				}
				
				i++;
			}
			System.out.println("Info: \n"+i);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		boolean result = uploadResult();
		if(result == true)
		{
			response.sendRedirect("dashboardTeacher.jsp?resultupload=success");
		}
		else
		{
			response.sendRedirect("dashboardTeacher.jsp?error");
		}
		
	}

}
