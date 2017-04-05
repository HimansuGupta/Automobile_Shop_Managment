package com.auto.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminregistration
 */
@WebServlet("/adminregistration")
public class adminregistration extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminregistration() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    Date dateobj = new Date();
	    System.out.println(df.format(dateobj));
	    String sysDate = df.format(dateobj);
		Connection connection = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managment_automobli_acc","root","root");
			System.out.println("SRK Himansu...");

			//its use for insert a data User_Registration table
			PreparedStatement psSelect=connection.prepareStatement("insert into admin_registration(Admin_Name,Admin_Username,Admin_Password,Admin_Date,Admin_Contact,Admin_Address,Approved_By) values(?,?,?,?,?,?,?)");
			psSelect.setString(1,request.getParameter("name"));
			psSelect.setString(2,request.getParameter("username") );
			psSelect.setString(3,request.getParameter("password"));
			psSelect.setString(4,sysDate);
			psSelect.setString(5,request.getParameter("contact"));
			psSelect.setString(6,request.getParameter("address"));
			psSelect.setString(7,request.getParameter("approved"));
			psSelect.executeUpdate();

			//its use for insert a data User_login table
			psSelect=connection.prepareStatement("insert into adminlogin(Admin_Name,Admin_Password) values (?, ?)");

			psSelect.setString(1,request.getParameter("username"));
			psSelect.setString(2,request.getParameter("password"));
			psSelect.executeUpdate();

			connection.close();
			response.sendRedirect("adminloginmain.jsp");			
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