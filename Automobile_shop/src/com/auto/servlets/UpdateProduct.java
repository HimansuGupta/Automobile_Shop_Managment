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
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
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
			request.getRequestDispatcher("adminprofilemain.jsp").forward(request, response);
			System.out.println("updateproduct.java");	
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
