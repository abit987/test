package com.payrollapi.api.model;

public class ApproverRequestBody 
{
 	
	private int empId;
	
 	private String  firstName;
	
 	private String  lastName;
	
 	private String  department;
	
 	private String  managerName;
 
	public String getFirstName() 
	{
		return firstName;
	}

	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public int getEmpId() 
	{
		return empId;
	}

	public void setEmpId(int empId) 
	{
		this.empId = empId;
	}
	
	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department) 
	{
		this.department = department;
	}

	public String getManagerName() 
	{
		return managerName;
	}

	public void setManagerName(String managerName) 
	{
		this.managerName = managerName;
	}

}
