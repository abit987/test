package com.payrollapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payrollapi.api.model.EmployeeRequestBody;
import com.payrollapi.api.model.LeaveRequestBody;
import com.payrollapi.api.model.LeaveCodeRequest;
import com.payrollapi.api.model.EmpIdRequest;
import com.payrollapi.api.service.LeaveService;
  
@RestController
@CrossOrigin
public class LeaveController 
{
	
	@Autowired
	private LeaveService leaveService;  // jo EmployeeService class hai uska
	                                         // object likha hai yeah - employeeService
	
	@RequestMapping(value = "/createLeave", method = RequestMethod.POST)
	public ResponseEntity<?> createLeave(@RequestBody LeaveRequestBody leaveReqBody) throws Exception 
	{
		return ResponseEntity.ok(leaveService.createLeave(leaveReqBody));
	}
	
	@RequestMapping(value = "/updateLeave", method = RequestMethod.PUT)
	public ResponseEntity<?> updateLeave(@RequestBody LeaveRequestBody leaveReqBody) throws Exception 
	{
		return ResponseEntity.ok(leaveService.updateLeave(leaveReqBody));
	}		
	
	@RequestMapping(value = "/listAllLeave", method = RequestMethod.GET)
	public ResponseEntity<?> listAllLeave(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception 
	{
		return ResponseEntity.ok(leaveService.listallleavefromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteLeave", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteLeave(@RequestBody LeaveCodeRequest leave) throws Exception 
	{
		return ResponseEntity.ok(leaveService.deleteLeave(leave)); 
	}
	
//	//Delete leave
//		@RequestMapping(value = "/deleteLeave", method = RequestMethod.DELETE)
//		public ResponseEntity<?> deleteLeave(@RequestBody LeaveCodeRequest leave) throws Exception {
//			return ResponseEntity.ok(leaveService.deleteLeave(leave));
//		}	
	
	
}
