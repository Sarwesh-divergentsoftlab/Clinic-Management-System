package com.divergentsl.clinicmanagementsystem;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Home {
	public static void main(String[] args) throws Exception
	
	{
		
		ApplicationContext context= new ClassPathXmlApplicationContext("Beans.xml");
	System.out.println("-----Welcome to clinic management system-----");
	Scanner sc= new Scanner (System.in);
	System.out.println("press 1 : Admin");
	System.out.println("Press 2 : Doctor");
	String n =sc.next();
	
	switch(n)
	{
	case "1":
		//LoginAdmin.checkAdmin();
		LoginAdmin a=(LoginAdmin)context.getBean("loginAdmin");
		a.checkAdmin();
		
		break;
	case "2":
		LoginDoctor d=(LoginDoctor)context.getBean("loginDoctor");
		String nameId= d.checkDoctor();
		
		if(nameId==null)
		{
			System.out.println("invalid password\n try again\n");
			main(args);
		}
		else Doctor.doctorPanel(nameId);
		break;
	default:
		System.out.print("enter valid input\n");
		main(args);
	
	}
	sc.close();
	
}

}
