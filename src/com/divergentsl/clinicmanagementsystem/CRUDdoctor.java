package com.divergentsl.clinicmanagementsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.divergentsl.clinicmanagementsystem.dao.DoctorDao;

public class CRUDdoctor {
	
	
	
  public static void doctorDao() throws SQLException
  {
	  Scanner sc= new Scanner (System.in);
	
	
	System.out.println("Enter your choice");
	System.out.println("press 1 : to create doctor");
	System.out.println("press 2 : to see all doctor list");
	System.out.println("press 3 : to update doctor");
	System.out.println("press 4 : to delete doctor");
	String choice=sc.next() ;
		
		switch(choice)
		{
		case "1": //create Doctor
				insert();
					break;
				
				
		case "2": //retrive doctor
				retrive();
					break;
		case "3": //update doctor
				update();
					break;
		
		case "4"://delete doctor
			System.out.println("Enter doctor_id");
			String idd=sc.next();
			DoctorDao doctorDao= new DoctorDao(new DatabaseManager());
			int i=doctorDao.deleteDotor(idd);
			if(i==0) System.out.print("doctor not found");
			break;
		}
		sc.close();
  }
		
		public static void insert()
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("enter doctor name");
			String name = sc.next();
			System.out.println("enter doctor id");
			String doctor_id= sc.next();
			System.out.println("enter doctor fees");
			String fees=sc.next();
			System.out.println("enter doctor degree");
			String degree=sc.next();
			System.out.println("enter doctor prescription");
			String prescription=sc.next();
			DoctorDao doctorDao=new DoctorDao(new DatabaseManager());
			try
			{
				doctorDao.insertDoctor(name,doctor_id,fees,degree,prescription);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			sc.close();
		}
		
		public static void retrive()throws SQLException
		{
			
			DoctorDao doctorDao= new DoctorDao(new DatabaseManager());
			ResultSet rsretrive= doctorDao.showDoctor();
			while(rsretrive.next())
			{
				System.out.println(rsretrive.getString(1)+" "+rsretrive.getString(2)+" "+rsretrive.getString(3)+" "+rsretrive.getString(4)+" "+rsretrive.getString(5)+" \n\n");
			}
			
		}
		
		public static void update() throws SQLException
		{
			Scanner sc = new Scanner(System.in);
		System.out.println("enter doctor id to you need to update ");
		String id=sc.next();
		System.out.println("enter choice");
		System.out.println("press 1 : to update name");
		System.out.println("press 2 : to update specialization");
		System.out.println("press 3 : to update fees");
		System.out.println("press 4 : to update degree");
		System.out.println("press 5 : to update prescription");
		String n=sc.next();
			switch(n)
			{
			case "1":
				System.out.println("enter updated name");
				DoctorDao doctorDao= new DoctorDao(new DatabaseManager());
				String dname=sc.next();
				int rowupdatename=doctorDao.updateName(dname, id);
				if(rowupdatename>0) System.out.print("information updated");
				break;
			
			case "2":
			
				System.out.println("enter updated specialization");
				String dspec=sc.next();
				doctorDao= new DoctorDao(new DatabaseManager());
				int rowupdatespec=doctorDao.updateSpecialization(dspec,id);
				if(rowupdatespec>0) System.out.print("information updated");
				break;
			
			case "3":
				System.out.println("enter updated fees");
				String dfees=sc.next();
				doctorDao= new DoctorDao(new DatabaseManager());
				int rowupdatefees=doctorDao.updateFees(dfees,id);
				if(rowupdatefees>0) System.out.print("information updated");
				break;
			
			case "4":
				
				System.out.println("enter updated degree");
				String ddegree=sc.next();
				doctorDao= new DoctorDao(new DatabaseManager());
				int rowupdatedegree=doctorDao.updateDegree(ddegree,id);
				if(rowupdatedegree>0) System.out.print("information updated");
				break;
			
			case "5":	
				
				System.out.println("enter updated prescription");
				String dpres=sc.next();
				doctorDao= new DoctorDao(new DatabaseManager());
				int rowupdate=doctorDao.updatePrescription(dpres, id);
				if(rowupdate>0) System.out.print("information updated");
				break;
			
					default:
						System.out.println("Enter Valid choice");
			}
		sc.close();
		}
  	
  }
