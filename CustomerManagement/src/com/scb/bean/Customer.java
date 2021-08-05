package com.scb.bean;

public class Customer 
{
	
	int id;
	String name;
	long phone;
	String type;
	String email;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customer(String name, long phone, String type, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.type = type;
		this.email = email;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", type=" + type + ", email=" + email
				+ "]";
	}
	
	
	

}
