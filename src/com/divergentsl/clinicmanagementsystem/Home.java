package com.divergentsl.clinicmanagementsystem;

import java.util.Scanner;

public class Home {
	public static void main(String[] args) throws Exception
	
	{
	System.out.println("-----Welcome to clinic management system-----");
	
	Scanner sc= new Scanner (System.in);
	System.out.println("press 1 : Admin");
	System.out.println("Press 2 : Doctor");
	int n =sc.nextInt();
	
	switch(n)
	{
	case 1:
		LoginAdmin.checkAdmin();
		break;
	case 2:
		String nameId= LoginDoctor.checkDoctor();
		
		if(nameId==null)
		{
			System.out.println("invalid password");
			System.exit(0);
		}
		else Doctor.doctorPanel(nameId);
		break;
	default:
		System.out.print("enter valid input");
		main(args);
	
	}
	
	
}

}
