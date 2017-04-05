package com.auto.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminAuthentication
 */
@WebServlet("/AdminAuthentication")
public class AdminAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAuthentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet result=null;
		PreparedStatement psSelect = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managment_automobli_acc","root","root");
			System.out.println("SRK Himansu...");

			psSelect=connection.prepareStatement("select * from adminlogin where Admin_Name=? and Admin_Password=? ");
			psSelect.setString(1,request.getParameter("username"));
			psSelect.setString(2,request.getParameter("password"));
			
			result=psSelect.executeQuery();
		
			if(result.next())
			{
				System.out.println(result.getString("Admin_Id"));
				System.out.println(result.getString("Admin_Name"));
				System.out.println(result.getString("Admin_Password"));
				HttpSession Session=request.getSession();
				Session.setAttribute("Admin_Name",request.getParameter("username"));
				request.setAttribute("adminName", request.getParameter("username"));
				request.getRequestDispatcher("adminprofilemain.jsp").forward(request, response);
				//response.sendRedirect("User_Profile.jsp");
			}
			else
			{
				request.setAttribute("Error_Message", "In valid Username and Passwor");
				request.getRequestDispatcher("adminloginmain.jsp").forward(request, response);
				
				System.out.println("Wrong password");
			}
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
}

