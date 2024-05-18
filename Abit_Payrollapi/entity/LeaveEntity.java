package com.payrollapi.api.entity;
import javax.persistence.*;


@Entity
@Table(name = "abit_leave")
public class LeaveEntity 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "empId", nullable = false)
//	private int empId;
	
	@Column(name = "Type", nullable = false) 
	private String  Type;
	
	@Column(name = "Description", nullable = false) 
	private String  Description;
	
	@Column(name = "totalDays", nullable = false) 
	private String  totalDays;
	
	@Column(name = "leaveCode", nullable = false) 
	private String  leaveCode;

//	public int getEmpId() {
//		return empId;
//	}

//	public void setEmpId(int empId) {
//		this.empId = empId;
//	}

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

	public String getTotalDays() 
	{
		return totalDays;
	}

	public void setTotalDays(String totalDays) 
	{
		this.totalDays = totalDays;
	}

	public String getLeaveCode() 
	{
		return leaveCode;
	}

	public void setLeaveCode(String leaveCode) 
	{
		this.leaveCode = leaveCode;
	}

}
