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

/**
 * Servlet implementation class SaveInDB
 */
@WebServlet("/SaveInDB")
public class SaveInDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveInDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("SaveInDB...");
		
		Connection connection = null;
		PreparedStatement psSelect = null;
		ResultSet resultSet = null;
		int result = 0;
		
		String[] id = request.getParameterValues("id");
		String[] company = request.getParameterValues("company");
		String[] name = request.getParameterValues("name");
		String[] price = request.getParameterValues("price");
		String[] available = request.getParameterValues("available");
		String[] sold = request.getParameterValues("sold");
		String[] total = request.getParameterValues("total");
		String[] address = request.getParameterValues("address");
		
		for (int i = 0; i < address.length; i++)
		{
			System.out.println("inside for"+company[i]);
		}
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managment_automobli_acc","root","root");
			
			
			for (int i = 0; i < price.length; i++) 
			{
				psSelect=connection.prepareStatement("select * from products WHERE prd_company=? and prd_name=? and address=?");
				
				
				psSelect.setString(1,company[i]);
				psSelect.setString(2, name[i]);
				psSelect.setString(3,address[i]);
										
				resultSet = psSelect.executeQuery();
				resultSet.getFetchSize();
				resultSet.getRow();
				if (resultSet.getRow()>0)
				{
					
					System.out.println("Record Already In Db So Please Update Not Add"+"company "+ company[i] +"Product "+name[i]+ "address "+address[i]);
					request.setAttribute("Error_Message","Record Already In Db So Please Update Not Add"+"company "+ company[i] 
							+"Product "+name[i]+ "address "+address[i]);
					request.getRequestDispatcher("addproduct.jsp").forward(request, response);
				}
				else 
				{
					psSelect=connection.prepareStatement("insert into products(prd_id, address, prd_company, prd_name, prd_price, unit_available, units_sold, unit_total)"
							+ " values(?,?,?,?,?,?,?,?)");
					
					psSelect.setInt(1,Integer.parseInt(id[i]));
					psSelect.setString(2,address[i]);
					psSelect.setString(3,company[i]);
					psSelect.setString(4, name[i]);
					psSelect.setInt(5,Integer.parseInt(price[i]));
					psSelect.setInt(6,Integer.parseInt(available[i]));
					psSelect.setInt(7,Integer.parseInt(sold[i]));
					psSelect.setInt(8,Integer.parseInt(total[i]));
					
					result = psSelect.executeUpdate();
				//	request.setAttribute("Message","Inserted Number "+result+" recoed Sucessfully ");
				//	request.getRequestDispatcher("adminprofilemain.jsp").forward(request, response);
				}
			}
			
			request.setAttribute("Message","Inserted Number "+result+" recoed Sucessfully ");
			request.getRequestDispatcher("adminprofilemain.jsp").forward(request, response);
			System.out.println(psSelect.executeBatch().length);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				psSelect.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
	
	
}
