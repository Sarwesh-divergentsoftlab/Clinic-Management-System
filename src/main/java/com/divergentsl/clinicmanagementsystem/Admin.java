package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class Admin {

	public static void adminPanel() throws Exception {
		Scanner sc= new Scanner(System.in);
		try {
			System.out.println("welcome to admin panel");
		
		System.out.println("press 1 : doctor manager");
		System.out.println("press 2 : patient manager");
		System.out.println("press 3 : drug manager");
		System.out.println("press 4 : labtest manager");
		System.out.println("press 5 : make appointment");
		System.out.println("press 6 : logout");
		String c=sc.next();
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		CRUDdoctor d = context.getBean(CRUDdoctor.class);
		CRUDpatient p = context.getBean(CRUDpatient.class);
		CRUDdrug r = context.getBean(CRUDdrug.class);
		CRUDlabtest l = context.getBean(CRUDlabtest.class);
		LoginAdmin login = context.getBean(LoginAdmin.class);
		Appointment apoint = context.getBean(Appointment.class);
		
		switch(c)
		{
				case "1"://doctor manager
				 // CRUDdoctor.doctorDao();
				  d.doctorDao();
				  break;
					
					
					
		case "2": //patient manager
				//CRUDpatient.patientDao();
				p.patientDao();
				break;
		
		case "3": //DRUG manager
				//CRUDdrug.drugDao();
				r.drugDao();
				break;
			
				
				
				
		case "4": //labtest manager
				//CRUDlabtest.labtestDao();
				l.labtestDao();
				break;
			

		case "5"://appointment
			//Appointment.addAppointment();
			apoint.addAppointment();
				break;
		
		case "6"://logout
			//LoginAdmin.checkAdmin();
			login.checkAdmin();	
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
 