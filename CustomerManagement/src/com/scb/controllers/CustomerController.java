package com.scb.controllers;

import java.util.*;

import com.scb.bean.Customer;
import com.scb.services.CustomerService;
import com.scb.services.CustomerServiceImpl;

public class CustomerController 
{
	CustomerService service=new CustomerServiceImpl();
	Scanner sc=new Scanner(System.in);
	
	public void addCustomer()
	{
		System.out.println("Please enter the Customers Details");
		
		
		String name;
		long phone;
		String email;
		String type;
		
		System.out.print("Enter Name:");
		name=sc.next();
		
		System.out.print("Enter Email:");
		email=sc.next();
		
		System.out.print("Enter Phone:");
		phone=sc.nextLong();
		
		System.out.print("Enter Type [Current,Savings]:");
		type=sc.next();
		
		Customer c=new Customer(name, phone, type, email);
		//System.out.println(c);
		
		service.addCustomer(c);
		
	}
	
	public void displayCustomers()
	{
		List<Customer> list=service.getAllCustomers();
		
		for(Customer c:list)
		{
			System.out.println(c);
		}
	}
	
	public void searchCustomer()
	{
		System.out.print("Please enter the ID of Customer:");
		int id=sc.nextInt();
		Customer c=service.getCustomerById(id);
		
		if(c!=null)
		{
			System.out.println(c);
		}
		else
		{
			System.out.println("No Customer Found!!");
		}
	}
	
	public void deleteCustomer()
	{
		System.out.print("Please enter the ID of Customer you want to Delete:");
		int id=sc.nextInt();
		service.deleteCustomer(id);
	}
}
