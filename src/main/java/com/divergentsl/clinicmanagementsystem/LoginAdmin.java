package com.divergentsl.clinicmanagementsystem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.divergentsl.clinicmanagementsystem.dao.LoginDao;


@Component
public class LoginAdmin {

	public void checkAdmin() throws Exception { 

		try {
		//	Console c= System.console();
		//	if(c==null)
		//		System.err.print("c is null");
			Scanner sc= new Scanner (System.in);
			
			
			LoginDao ado=new LoginDao(new DatabaseManager());
			ResultSet rs= ado.adminLogin();
			 
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
		sc.close();
		}
		catch(SQLException ex)
			{
				ex.printStackTrace();
			}
	}

}
