package com.payrollapi.api.model;

public class LeaveRequestBody 
{
 	
	
	
    public String Type;
	
 	public String Description;
	
 	private String  totalDays;
	
 	private String  leaveCode;
 
	public String getType() 
	{
		return Type;
	}

	public void setType(String Type) 
	{
		this.Type = Type;
	}

	public String getDescription() 
	{
		return Description;
	}

	public void setDescription(String Description) 
	{
		this.Description = Description;
	}

	public String gettotalDays() 
	{
		return totalDays;
	}

	public void settotalDays(String totalDays) 
	{
		this.totalDays = totalDays;
	}

	public String getleaveCode() 
	{
		return leaveCode;
	}

	public void setleaveCode(String leaveCode) 
	{
		this.leaveCode = leaveCode;
	}

	

	

//	public int getEmpId() 
//	{
//		return empId;
//	}
//
//	public void setEmpId(int empId) 
//  {
//		this.empId = empId;
//  }
//	

}
