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
import com.payrollapi.api.model.ApplyLeaveRequestBody;
import com.payrollapi.api.model.EmpIdRequest;
import com.payrollapi.api.service.ApplyLeaveService;
import com.payrollapi.api.service.EmployeeService;
  
@RestController
@CrossOrigin
public class ApplyLeaveController 
{
	
	@Autowired
	private ApplyLeaveService applyLeaveService;	
	
	@RequestMapping(value = "/createApplyLeave", method = RequestMethod.POST)
	public ResponseEntity<?> createApplyLeave(@RequestBody ApplyLeaveRequestBody applyleaveReqBody) throws Exception {
		return ResponseEntity.ok(applyLeaveService.createApplyLeave(applyleaveReqBody));
	}
	
	@RequestMapping(value = "/updateApplyLeave", method = RequestMethod.PUT)
	public ResponseEntity<?> updateApplyLeave(@RequestBody ApplyLeaveRequestBody applyleaveReqBody) throws Exception {
		return ResponseEntity.ok(applyLeaveService.updateApplyLeave(applyleaveReqBody));
	}		
	
	@RequestMapping(value = "/listAllApplyLeave", method = RequestMethod.GET)
	public ResponseEntity<?> listAllApplyLeave(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(applyLeaveService.listallapplyleavefromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteApplyLeave", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteApplyLeave(@RequestBody EmpIdRequest user) throws Exception {
		return ResponseEntity.ok(applyLeaveService.deleteApplyLeave(user));
	}		
	
}
