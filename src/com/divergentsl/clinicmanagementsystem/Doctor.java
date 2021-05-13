package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {

	public static void doctorPanel(String dname) throws SQLException {
		
		
		Scanner sc=new Scanner(System.in);
		 System.out.println("\n----Login as : " + dname + "----");
		    System.out.println("----Doctor Panel----");
		    System.out.println("1. List of patients");
		    System.out.println("2. Add prescription and notes for a patient");
		    System.out.println("3. See booked appointments for him");
		    System.out.println("4. Check patient history and his prescription");
		    System.out.println("5. Create Invoice of patient");
		    System.out.println("6. Logout");
		    System.out.println("	Enter Your Choice: \n");
		    String choice=sc.next();
		    switch(choice)
		    {
		    case "1":
		    	Appointment.listPatient(dname);
		    	break;
		    
		    case "2":
		    	Appointment.addPrescription();
		    	break;
		    case "3":
		    	Appointment.assignedAppointment(dname);
		    	break;
		    case "4":
		    	Appointment.patientHistory();
		    	break;
		    case "5":
		    	Appointment.generateInvoice();
		    	break;
		    case "6":
		    	
		    	System.out.println("\nlogout successful\n");
		    	LoginDoctor.checkDoctor();
		    	break;
		    	
		    default:
		    	System.out.print("enter valid input\n");
		    	doctorPanel(dname);
		    }
	sc.close();
	} 

}
