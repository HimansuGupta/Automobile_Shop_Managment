package com.auto.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) {
		try
		{
			PreparedStatement psSelect=null;
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managment_automobli_acc","root","root");
			System.out.println("Himansu...");
			
			String price[] = {"22","33","24"};
			String available[] = {"15","15","15"};
			String sold[] = {"15","15","15"};
			String total[] = {"30","30","30"};
			String company[] = {"Honda ","Hero ","TVS"};
			String product[] = {"Brake Shoe ","Tail Light","Gear Wire"};
			String address[] = {"Nampally ","Tolichowki","Mehdipatnam"};
			
			//its use for insert a data User_login table
			//psSelect=connection.prepareStatement("insert into userlogin(User_Name,User_Password) values (?, ?)");

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
				
				System.out.println("company "+company[i]);
				System.out.println("product "+product[i]);
				System.out.println("prices "+price[i]);
				System.out.println("available "+available[i]);
				System.out.println("sold "+sold[i]);
				System.out.println("total "+total[i]);
				System.out.println("address "+address[i]);
						
				psSelect.addBatch();
				
							
			}
			
			System.out.println(psSelect.executeBatch().length);
		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

}
