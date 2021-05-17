package com.divergentsl.clinicmanagementsystem;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Home {
		public void home()throws Exception
		{
			System.out.println("-----Welcome to clinic management system-----");
			Scanner sc= new Scanner (System.in);
			System.out.println("press 1 : Admin");
			System.out.println("Press 2 : Doctor");
			String n =sc.next();
			ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
			
			
			LoginDoctor ldo=context.getBean(LoginDoctor.class);
			LoginAdmin lao= context.getBean(LoginAdmin.class);
			Doctor d=new Doctor();
			
			switch(n)
			{
			case "1":
				lao.checkAdmin();
				//LoginAdmin a=(LoginAdmin)context.getBean("loginAdmin");
				//a.checkAdmin();
				
				break;
			case "2":
				//LoginDoctor d=(LoginDoctor)context.getBean("loginDoctor");
				String nameId= ldo.checkDoctor();
				
				if(nameId==null)
				{
					System.out.println("invalid password\n try again\n");
				}
				else d.doctorPanel(nameId);
				break;
			default:
				System.out.print("enter valid input\n");
			
			}
			sc.close();
			
		}



	}

