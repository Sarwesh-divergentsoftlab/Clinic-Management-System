package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginDoctor {
	public static String checkDoctor()
	{

		try {
			
			Scanner sc= new Scanner (System.in);
			
			Connection connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/clinicmanagement",
					"root","root");
			String sqlst="Select * from login_doctor";
			Statement statement=connection.createStatement();
			ResultSet rs= statement.executeQuery(sqlst);
			 
			System.out.println("Enter your user name: ");  
		     String user=sc.next(); 
		    System.out.println("enter password"); 
		     String pass = sc.next();
			boolean flag=false;
			String userName=" ";
			String password=" ";
			while(rs.next())
			{
				 userName=rs.getString(1);		//1st coloumn in database
				 password = rs.getString(2);		//2nd coloumn in database
				
				if(user.equals(userName) && pass.equals(password))
				{
					System.out.print("Login successful");
					
					
					flag=true;
					return userName;
				
					
				}
			}
			
		}
		catch(SQLException ex)
			{
				ex.printStackTrace();
			}
	return null;	
	}

}
