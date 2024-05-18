package com.payrollapi.api.service;

import com.payrollapi.api.entity.ApproverEntity;
import com.payrollapi.api.model.EmpIdRequest;
import com.payrollapi.api.model.ApproverRequestBody; 
import com.payrollapi.api.repositories.ApproverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class ApproverService  {

	@Autowired
	private ApproverRepository ApproverRepository;

	

	public ApproverEntity createApprover(ApproverRequestBody approverReqBody) {

		ApproverEntity newApprover = new ApproverEntity();
		newApprover.setFirstName(approverReqBody.getFirstName());
		newApprover.setLastName(approverReqBody.getLastName());
		newApprover.setDepartment(approverReqBody.getDepartment());
		newApprover.setManagerName(approverReqBody.getManagerName());
		return ApproverRepository.save(newApprover);		 
	}

	public ApproverEntity updateApprover(ApproverRequestBody approverReqBody) {
		ApproverEntity newApprover = new ApproverEntity();
		newApprover.setFirstName(approverReqBody.getFirstName());
		newApprover.setLastName(approverReqBody.getLastName());
		newApprover.setEmpId(approverReqBody.getEmpId());
		newApprover.setDepartment(approverReqBody.getDepartment());
		newApprover.setManagerName(approverReqBody.getManagerName());
		return ApproverRepository.save(newApprover);		 
	}

	public Page<ApproverEntity> listapproverfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return ApproverRepository.listapproverfromdb(pageable);
	}
 
	public String deleteApprover(EmpIdRequest user) {
		int employeeId= user.getEmpId();
		ApproverRepository.deleteById(employeeId);
		return "Record Deleted";
	}

}

