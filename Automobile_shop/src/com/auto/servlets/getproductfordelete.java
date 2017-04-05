package com.auto.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auto.pojo.Product;

/**
 * Servlet implementation class getproductfordelete
 */
@WebServlet("/getproductfordelete")
public class getproductfordelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getproductfordelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection connection = null;
		ResultSet result=null;
		PreparedStatement psSelect = null;
		List<Product> productList = new ArrayList<Product>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managment_automobli_acc","root","root");
			
			
			psSelect=connection.prepareStatement("select * from products");
						
			result=psSelect.executeQuery();
			
			while(result.next())
			{
				Product product = new Product();
				product.setPrd_id(result.getInt("prd_id"));
				product.setPrd_company(result.getString("prd_company"));
				product.setPrd_name(result.getString("prd_name"));
				product.setPrd_price(result.getString("prd_price"));
				product.setAddress(result.getString("address"));
				product.setUnits_available(result.getInt("unit_available"));
				product.setUnits_sold(result.getInt("units_sold"));
				product.setUnits_total(result.getInt("unit_total"));
				productList.add(product);
			}
			request.setAttribute("Data", productList);
			request.getRequestDispatcher("deleteproduct.jsp").forward(request, response);
			System.out.println("getproductfordelete.java");	
			connection.close();
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("in POST");
		String[] checkedIds = request.getParameterValues("checkbox");
		
		//DELETE FROM tutorials_tbl WHERE tutorial_id=3;
		
		Connection connection = null;
		int result = 0;
		PreparedStatement psSelect = null;
		//List<Product> productList = new ArrayList<Product>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managment_automobli_acc","root","root");
			for (int i = 0; i < checkedIds.length; i++)
			{
				psSelect=connection.prepareStatement("DELETE FROM products WHERE prd_id = ?;");
				psSelect.setInt(1,Integer.parseInt(checkedIds[i]));
				result = psSelect.executeUpdate();
				System.out.println(result);
			}
			request.setAttribute("Data", result);
			request.getRequestDispatcher("deleteproduct.jsp").forward(request, response);
			System.out.println("getproductfordelete.java");	
			connection.close();
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
