package com.divergentsl.clinicmanagementsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{	
	public static void main(String args[]) throws Exception
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Home h = context.getBean(Home.class);
		h.home();
	}	
	
}


