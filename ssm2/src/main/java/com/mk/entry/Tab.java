package com.mk.entry;

public class Tab
{
	private int id;
	private String name;
	private String password;

	public Tab()
	{
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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "Tab [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
}
