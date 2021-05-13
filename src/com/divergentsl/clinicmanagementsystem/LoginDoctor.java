package com.divergentsl.clinicmanagementsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.divergentsl.clinicmanagementsystem.dao.LoginDao;

public class LoginDoctor {
	public static String checkDoctor()
	{

		try {
			Scanner sc= new Scanner(System.in);
			LoginDao ldo = new LoginDao(new DatabaseManager());
			ResultSet rs= ldo.doctorLogin();
			 
			System.out.println("Enter your user name: ");  
		     String user=sc.next(); 
		    System.out.println("enter password"); 
		     String pass = sc.next();
			String userName=" ";
			String password=" ";	
			
			while(rs.next())
			{
				 userName=rs.getString(1);		//1st coloumn in database
				 password = rs.getString(2);		//2nd coloumn in database
				
				if(user.equals(userName) && pass.equals(password))
				{
					System.out.print("Login successful");
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
