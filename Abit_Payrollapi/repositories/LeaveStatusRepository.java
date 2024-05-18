package com.payrollapi.api.repositories;

import com.payrollapi.api.entity.leaveStatusEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveStatusRepository extends JpaRepository<leaveStatusEntity, Integer> {
    List<leaveStatusEntity> findByApprove(String approve);
    List<leaveStatusEntity> findByApproveNot(String approve); 
	List<leaveStatusEntity> findByEmpIdAndApprove(int empId, String approve);
	
    leaveStatusEntity findByLeaveId(@Param("leaveId") int leaveId);


}
