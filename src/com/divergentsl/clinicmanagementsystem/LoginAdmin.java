package com.divergentsl.clinicmanagementsystem;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginAdmin {

	public static void checkAdmin() throws Exception { 

		try {
		//	Console c= System.console();
		//	if(c==null)
		//		System.err.print("c is null");
			Scanner sc= new Scanner (System.in);
			
			Connection connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/clinicmanagement",
					"root","root");
			String sqlst="Select * from login_admin";
			Statement statement=connection.createStatement();
			ResultSet rs= statement.executeQuery(sqlst);
			 
			System.out.println("Enter your user name: ");  
		     String user=sc.next(); 
		    System.out.println("enter password"); 
		     String pass = sc.next();
			boolean flag=false;
			while(rs.next())
			{
				String userName=rs.getString(1);		//1st coloumn in database
				String password = rs.getString(2);		//2nd coloumn in database
				
				if(user.equals(userName) && pass.equals(password))
				{
					System.out.println("Login successful\n");
					Admin.adminPanel();
					flag=true;
					break;
				}
			}
			if(!flag)
			{
				System.out.println("your password or username may be incorrect\n");
				
				checkAdmin();
			}
		}
		catch(SQLException ex)
			{
				ex.printStackTrace();
			}
	}

}
