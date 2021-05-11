package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Admin {

	public static void adminPanel() throws Exception {
		Scanner sc= new Scanner(System.in);
		try {
			Connection connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/clinicmanagement",
					"root","root");
			Statement st = connection.createStatement();
			PreparedStatement statement;
		
		
	
		
		System.out.println("welcome to admin panel");
		
		System.out.println("press 1 : doctor manager");
		System.out.println("press 2 : patient manager");
		System.out.println("press 3 : drug manager");
		System.out.println("press 4 : labtest manager");
		System.out.println("press 5 : make appointment");
		System.out.println("press 6 : logout");
		int c=sc.nextInt();
		switch(c)
		{
				case 1://doctor manager
				  CRUDdoctor.doctorDao();
				  
				  break;
					
					
					
		case 2: //patient manager
				CRUDpatient.patientDao();
			
				break;
		
		case 3: //DRUG manager
				CRUDdrug.drugDao();
				
				break;
			
				
				
				
		case 4: //labtest manager
				CRUDlabtest.labtestDao();
				
				break;
			

		case 5://appointment
			Appointment.addAppointment();
			
				break;
		
		case 6://logout
			LoginAdmin.checkAdmin();
					
				default:
					System.out.print("Enter Valid choice");
					adminPanel();
					break;
				}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		sc.close();
		
	}
}
 