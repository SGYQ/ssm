package com.mk.employee.entry;
/**
 * <p> 员工实体信息
 * @author admin
 *
 */
public class Employee
{
	private int id;
	private String name;
	private int gender;
	private String email;
	private double salary; //薪资
	private Department dept;
	
	public Employee()
	{
	}
	
	
	
	@Override
	public String toString()
	{
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", salary="
				+ salary + ", dept=" + dept + "]";
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
	public int getGender()
	{
		return gender;
	}
	public void setGender(int gender)
	{
		this.gender = gender;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	public Department getDept()
	{
		return dept;
	}
	public void setDept(Department dept)
	{
		this.dept = dept;
	}
	
	
}
