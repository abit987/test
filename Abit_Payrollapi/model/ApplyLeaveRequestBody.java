package com.payrollapi.api.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;


public class ApplyLeaveRequestBody 
{
	
	private String  type;
	
    private int empId;
	
	private int  totalDays;
	
	private int  startDate;
	
	private int endDate;
	
	private String  reason;

	
	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}
	
	
	public int getEmpId() 
	{
		return empId;
	}

	public void setEmpId(int empId) 
	{
		this.empId = empId;
	}


	public int getTotalDays() 
	{
		return totalDays;
	}

	public void setTotalDays(int totalDays) 
	{
		this.totalDays = totalDays;
	}

	public int getStartDate() 
	{
		return startDate;
	}

	public void setStartDate(int startDate) 
	{
		this.startDate = startDate;
	}

	public int getEndDate() 
	{
		return endDate;
	}

	public void setEndDate(int endDate) 
	{
		this.endDate = endDate;
	}


	public String getReason() 
	{
		return reason;
	}

	public void setReason(String reason) 
	{
		this.reason = reason;
	}
	

}

