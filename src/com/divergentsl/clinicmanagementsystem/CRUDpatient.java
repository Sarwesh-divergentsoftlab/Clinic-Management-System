package com.divergentsl.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.divergentsl.clinicmanagementsystem.dao.DrugDao;
import com.divergentsl.clinicmanagementsystem.dao.PatientDao;

public class CRUDpatient {
	
	public static void patientDao() throws Exception
	{

	  Scanner sc= new Scanner (System.in);
		
		System.out.println("Enter your choice");
		System.out.println("press 1 : to add patient");
		System.out.println("press 2 : to see all patient list");
		System.out.println("press 3 : to update patient");
		System.out.println("press 4 : to delete patient");
		int pchoice=sc.nextInt() ;
			
			switch(pchoice)
			{
			case 1: //create patient
					System.out.println("enter patient name");
					String name = sc.next();
					System.out.println("enter patient age");
					String patient_age= sc.next();
					System.out.println("enter patient weight");
					String weight=sc.next();
					System.out.println("enter patient problem");
					String problem=sc.next();
					System.out.println("enter application date");
					String app_date=sc.next();
					System.out.println("enter patient contact number");
					String contact=sc.next();
					PatientDao patientDao= new PatientDao(new DatabaseManager());
					patientDao.insertPatient(name, patient_age, weight, problem, app_date, contact);
					break;
			
			
			case 2: //retrive patient
					patientDao= new PatientDao(new DatabaseManager());
					ResultSet rsretrive =patientDao.showPatient();
					while(rsretrive.next())
					{
						System.out.println(rsretrive.getString(1)+" "+rsretrive.getString(2)+" "+rsretrive.getString(3)+" "+rsretrive.getString(4)+" "+rsretrive.getString(5));
					}
					break;
					
			
			case 3: //update patient
					System.out.println("enter patient id");
					String id=sc.next();
					System.out.println("enter choice");
					System.out.println("press 1 : to update name");
					System.out.println("press 2 : to update age");
					System.out.println("press 3 : to update weight");
					System.out.println("press 4 : to update problem");
					System.out.println("press 5 : to update Application date");
					int n=sc.nextInt();
					String sqlupdate=" ";
						switch(n)
						{
						case 1:
							sqlupdate = "UPDATE patient SET name=? WHERE patient_id=? ";
							System.out.println("enter updated name");
							String pname=sc.next();
							patientDao= new PatientDao(new DatabaseManager());
							int rowupdatename=patientDao.updateName(pname, id);
							if(rowupdatename>0) System.out.print("information updated");
							break;
						
						case 2:
							sqlupdate = "UPDATE patient SET age=? WHERE patient_id=? ";
							System.out.println("enter updated age");
							String page=sc.next();
							patientDao= new PatientDao(new DatabaseManager());
							int rowupdatespec=patientDao.updateAge(page, id);
							if(rowupdatespec>0) System.out.print("information updated");
							break;
						
						case 3:
							sqlupdate = "UPDATE patient SET weight=? WHERE patient_id=? ";
							System.out.println("enter updated weight");
							String pweight=sc.next();
							patientDao= new PatientDao(new DatabaseManager());
							int rowupdatefees=patientDao.updateAge(pweight, id);
							if(rowupdatefees>0) System.out.print("information updated");
							break;
						
						case 4:
							sqlupdate = "UPDATE doctor SET problem=? WHERE patient_id=? ";
							System.out.println("enter new problem");
							String pproblem=sc.next();
							patientDao= new PatientDao(new DatabaseManager());
							int rowupdatedegree=patientDao.updateProblem(pproblem, id);
							if(rowupdatedegree>0) System.out.print("information updated");
							break;
						
						case 5:	
							sqlupdate = "UPDATE patient SET app_date=? WHERE patient_id=? ";
							System.out.println("enter updated Application date");
							String pdate=sc.next();
							patientDao= new PatientDao(new DatabaseManager());
							int rowupdate=patientDao.updateAppDate(pdate, id);
							if(rowupdate>0) System.out.print("information updated");
							break;
						
						case 6:	
							sqlupdate = "UPDATE patient SET app_date=? WHERE patient_id=? ";
							System.out.println("enter updated contact number");
							String contactc=sc.next();
							patientDao= new PatientDao(new DatabaseManager());
							int rowupdatec=patientDao.updateAppDate(contactc, id);
							if(rowupdatec>0) System.out.print("information updated");
							break;
						
						default:
							System.out.println("Enter Valid choice");
						}	
					
				
					
					break;
					
			case 4://delete patient
				System.out.println("Enter patient id");
				String idp=sc.next();
				patientDao= new PatientDao(new DatabaseManager());
				int i=patientDao.deletePatient(idp);
				if(i==0) System.out.print("patient not found");
				break;
			default:
				System.out.print("Enter Valid choice");
			}

	
	}
}
