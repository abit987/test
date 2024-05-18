package com.payrollapi.api.service;

import com.payrollapi.api.entity.ApplyLeaveEntity;
import com.payrollapi.api.model.EmpIdRequest;
import com.payrollapi.api.model.ApplyLeaveRequestBody; 
import com.payrollapi.api.repositories.ApplyLeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class ApplyLeaveService  {

	@Autowired
	private ApplyLeaveRepository applyLeaveRepository;

	

	public ApplyLeaveEntity createApplyLeave(ApplyLeaveRequestBody applyReqBody) {

		ApplyLeaveEntity newApplyLeave = new ApplyLeaveEntity();
		newApplyLeave.settype(applyReqBody.getType());
		newApplyLeave.setTotalDays(applyReqBody.getTotalDays());
		newApplyLeave.setStartDate(applyReqBody.getStartDate());
		newApplyLeave.setEndDate(applyReqBody.getEndDate());
		return applyLeaveRepository.save(newApplyLeave);		 
	}

	public ApplyLeaveEntity updateApplyLeave(ApplyLeaveRequestBody applyReqBody) {
		ApplyLeaveEntity newApplyLeave = new ApplyLeaveEntity();
		newApplyLeave.setEmpId(applyReqBody.getEmpId());
		newApplyLeave.settype(applyReqBody.getType());
		newApplyLeave.setTotalDays(applyReqBody.getTotalDays());
		newApplyLeave.setStartDate(applyReqBody.getStartDate());
		newApplyLeave.setEndDate(applyReqBody.getEndDate());
		return applyLeaveRepository.save(newApplyLeave);		 
	}

	public Page<ApplyLeaveEntity> listallapplyleavefromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return applyLeaveRepository.listallapplyleavefromdb(pageable);
	}
 
	public String deleteApplyLeave(EmpIdRequest user) {
		int employeeId= user.getEmpId();
		applyLeaveRepository.deleteById(employeeId);
		return "Record Deleted";
	}

}
