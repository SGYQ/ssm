package com.mk.emp.entry;

public class EmployeeBean
{
	private int id;
	private String name;
	private String email;
	private int gender;
	private double salary;
	
	private DeptBean dept;

	public EmployeeBean()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getGender()
	{
		return gender;
	}

	public void setGender(int gender)
	{
		this.gender = gender;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public DeptBean getDept()
	{
		return dept;
	}

	public void setDept(DeptBean dept)
	{
		this.dept = dept;
	}

	@Override
	public String toString()
	{
		return "EmployeeBean [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", salary="
				+ salary + ", dept=" + dept + "]";
	}
	
	
}
