package com.scb.ui;

import java.util.Scanner;

import com.scb.controllers.CustomerController;

public class CustomerUI 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		CustomerController controller=new CustomerController();
		
		System.out.println("----------------------Welcome to Standard Chartered Bank --------------------------");
		
		while(true)
		{
			System.out.println("Please Enter your choice");
			System.out.println("1 for Add New Customer");
			System.out.println("2 for Displaying All Customers");
			System.out.println("3 for Searching Customer");
			System.out.println("4 for Deleting a Customer");
			System.out.println("5 for Exiting the Application");
			
			int option=sc.nextInt();
			
			switch (option) {
			case 1:
				controller.addCustomer();
				break;
			case 2:
				controller.displayCustomers();
				break;
			case 3:
				controller.searchCustomer();
				break;
			case 4:
				controller.deleteCustomer();
				break;
			case 5:
				System.out.println("Thanks for using our services. Bye");
				System.exit(0);
				break;

			default:
				System.out.println("Option Unavailable");
				break;
			}
			
			System.out.println("\n\n\n_______________________________________________________\n\n\n");
		}
		
	}

}
