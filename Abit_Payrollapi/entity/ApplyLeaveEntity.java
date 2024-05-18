package com.payrollapi.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "abit_applyleave")
public class ApplyLeaveEntity 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "LeaveId", nullable = false) 
	private String  LeaveId;
	
	@Column(name = "type", nullable = false) 
	private String  type;
	
	@Column(name = "empId", nullable = false)
	private int empId;
	
	
	
	@Column(name = "TotalDays", nullable = false) 
	private int  TotalDays;
	
	@Column(name = "StartDate", nullable = false) 
	private int  StartDate;
	
	@Column(name = "EndDate", nullable = false) 
	private int  EndDate;
	
	@Column(name = "Reason", nullable = false) 
	private String  Reason;


	public String getLeaveId() 
	{
		return LeaveId;
	}
	
	public void setLeaveId(String LeaveId) 
	{
		this.LeaveId = LeaveId;
	}
	
	public String gettype() 
	{
		return type;
	}

	public void settype(String type) 
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
		return TotalDays;
	}

	public void setTotalDays(int TotalDays) 
	{
		this.TotalDays = TotalDays;
	}

	public int getStartDate() 
	{
		return StartDate;
	}

	public void setStartDate(int StartDate) 
	{
		this.StartDate = StartDate;
	}

	public int getEndDate() 
	{
		return EndDate;
	}

	public void setEndDate(int EndDate) 
	{
		this.EndDate = EndDate;
	}


	public String getReason() 
	{
		return Reason;
	}

	public void setReason(String Reason) 
	{
		this.Reason = Reason;
	}
	

}

