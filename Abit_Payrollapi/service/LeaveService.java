package com.payrollapi.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.payrollapi.api.model.EmpIdRequest;
import com.payrollapi.api.model.LeaveCodeRequest;
import com.payrollapi.api.repositories.LeaveRepository;
import com.payrollapi.api.entity.EmployeeEntity;
import com.payrollapi.api.entity.LeaveEntity;
//import com.payrollapi.api.model.EmpIdRequest;
import com.payrollapi.api.model.EmployeeRequestBody;
import com.payrollapi.api.repositories.EmployeeRepository;
import com.payrollapi.api.model.LeaveRequestBody;
//import com.payrollapi.api.repositories.LeaveRepository;



@Service
public class LeaveService  
{

private LeaveRepository leaveDao;
	
@Autowired
private LeaveRepository leaveRepository;
//private EmployeeRepository employeeRepository;

	
//
//	public EmployeeEntity createEmployee(EmployeeRequestBody empReqBody) {
//
//		EmployeeEntity newEmployee = new EmployeeEntity();
//		newEmployee.setFirstName(empReqBody.getFirstName());
//		newEmployee.setLastName(empReqBody.getLastName());
//		newEmployee.setDepartment(empReqBody.getDepartment());
//		newEmployee.setManagerName(empReqBody.getManagerName());
//		return employeeRepository.save(newEmployee);		 
//	}


	public LeaveEntity createLeave(LeaveRequestBody leaveReqBody) {

		LeaveEntity newLeave = new LeaveEntity();
		newLeave.setType(leaveReqBody.getType());
		newLeave.setDescription(leaveReqBody.getDescription());
		newLeave.setTotalDays(leaveReqBody.gettotalDays());
		newLeave.setLeaveCode(leaveReqBody.getleaveCode());
		return leaveRepository.save(newLeave);
	}
	
	

	
	
	
//	
//	public EmployeeEntity updateEmployee(EmployeeRequestBody empReqBody) {
//		EmployeeEntity newEmployee = new EmployeeEntity();
//		newEmployee.setEmpId(empReqBody.getEmpId());
//		newEmployee.setFirstName(empReqBody.getFirstName());
//		newEmployee.setLastName(empReqBody.getLastName());
//		newEmployee.setDepartment(empReqBody.getDepartment());
//		newEmployee.setManagerName(empReqBody.getManagerName());
//		return employeeRepository.save(newEmployee);		 
//	}

	public LeaveEntity updateLeave(LeaveRequestBody leaveReqBody) {

		LeaveEntity newLeave = new LeaveEntity();
		newLeave.setType(leaveReqBody.getType());
		newLeave.setDescription(leaveReqBody.getDescription());
		newLeave.setTotalDays(leaveReqBody.gettotalDays());
		newLeave.setLeaveCode(leaveReqBody.getleaveCode());
		return leaveRepository.save(newLeave);
		
		
	}
	

	
	
//	public Page<EmployeeEntity> listallusersfromdb(int pageNumber, int size) {
//		Pageable pageable = PageRequest.of(pageNumber, size);
//		return employeeRepository.listallusersfromdb(pageable);
//	}
 
	
	public Page<LeaveEntity> listallleavefromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return leaveRepository.listallleavefromdb(pageable);
	}


//
//	public LeaveEntity createLeave(LeaveRequestBody leaveReqBody) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public String deleteLeave(com.payrollapi.api.model.LeaveCodeRequest leave) {
		int leaveCode= leave.getLeaveCode();
		leaveDao.deleteById(leaveCode);
		return "Record Deleted";
	}
	
	
	
//	public String deleteEmployee(EmpIdRequest user) {
//		int employeeId= user.getEmpId();
//		employeeRepository.deleteById(employeeId);
//		return "Record Deleted";
//	}
	
//	
//	public LeaveEntity deleteLeave(LeaveRequestBody leaveReqBody) {
//
//		LeaveEntity newLeave = new LeaveEntity();
//		newLeave.setType(leaveReqBody.getType());
//		newLeave.setDescription(leaveReqBody.getDescription());
//		newLeave.settotalDays(leaveReqBody.gettotalDays());
//		newLeave.setleaveCode(leaveReqBody.getleaveCode());
//		return leaveRepository.save(newLeave);		 
//	}
	
	

}
