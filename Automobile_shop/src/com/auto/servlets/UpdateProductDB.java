package com.auto.servlets;

import java.awt.PageAttributes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.scene.paint.GradientUtils.Parser;

/**
 * Servlet implementation class UpdateProductDB
 */
@WebServlet("/UpdateProductDB")
public class UpdateProductDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection connection = null;
		PreparedStatement psSelect = null;
		
		String[] company= request.getParameterValues("company");
		String[] product= request.getParameterValues("product");
		String[] price= request.getParameterValues("price");
		String[] available= request.getParameterValues("available");
		String[] sold= request.getParameterValues("sold");
		String[] total= request.getParameterValues("toatal");
		String[] address= request.getParameterValues("address");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managment_automobli_acc","root","root");
					
			psSelect=connection.prepareStatement("UPDATE products SET prd_price=? , unit_available=?, units_sold=? "
					+ ",unit_total=? WHERE prd_company=? and prd_name=? and address=?");
			
			for (int i = 0; i < price.length; i++) 
			{
				psSelect.setInt(1,Integer.parseInt(price[i]));
				psSelect.setInt(2,Integer.parseInt(available[i]));
				psSelect.setInt(3,Integer.parseInt(sold[i]));
				psSelect.setInt(4,Integer.parseInt(total[i]));
				psSelect.setString(5,company[i]);
				psSelect.setString(6,product[i]);
				psSelect.setString(7,address[i]);
										
				psSelect.addBatch();
			}
			
			System.out.println(psSelect.executeBatch().length);
			psSelect.close();
			connection.close();
			request.setAttribute("Message","Update All recoed Sucessfully");
			request.getRequestDispatcher("adminprofilemain.jsp").forward(request, response);
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
