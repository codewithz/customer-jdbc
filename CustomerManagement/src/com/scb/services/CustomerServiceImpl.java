package com.scb.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.scb.bean.Customer;
import com.scb.helper.DatabaseConnector;

public class CustomerServiceImpl implements CustomerService
{

	@Override
	public void addCustomer(Customer c) 
	{
		Connection con=null;
		
		try
		{
			con=DatabaseConnector.getConnection();
			
			String query="Insert into customer(name,phone,type,email) values (?,?,?,?);";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1,c.getName());
			pstmt.setLong(2,c.getPhone());
			pstmt.setString(3,c.getType());
			pstmt.setString(4,c.getEmail());
			
			int rowAffected=pstmt.executeUpdate();
			
			if(rowAffected==1)
			{
				System.out.println("Customer Added successfully");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public List<Customer> getAllCustomers() 
	{
		ArrayList<Customer> list=new ArrayList<>();
		
		Connection con=null;
		
		try
		{
			con=DatabaseConnector.getConnection();
			String query="Select id,name,phone,type,email from customer";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				long phone=rs.getLong("phone");
				String type=rs.getString("type");
				String email=rs.getString("email");
				
				Customer c=new Customer(name, phone, type, email);
				c.setId(id);
				
				list.add(c);
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public Customer getCustomerById(int id) 
	{
		Customer customer=null;
		
		Connection con=null;
		
		try
		{
			con=DatabaseConnector.getConnection();
			String query="Select id,name,phone,type,email from customer where id=?";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				
				String name=rs.getString("name");
				long phone=rs.getLong("phone");
				String type=rs.getString("type");
				String email=rs.getString("email");
				
				customer=new Customer(name, phone, type, email);
				customer.setId(id);
				
				
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) 
	{
		Connection con=null;
		
		try
		{
			con=DatabaseConnector.getConnection();
			String query="Delete from customer where id=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,id);
			
			int rowDeleted=pstmt.executeUpdate();
			
			if(rowDeleted==1)
			{
				System.out.println("Customer with ID "+id+" deleted successfully");
			}
			else
			{
				System.out.println("Customer does not exists");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
