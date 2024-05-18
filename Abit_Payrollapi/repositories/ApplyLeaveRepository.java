package com.payrollapi.api.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payrollapi.api.entity.ApplyLeaveEntity;
import com.payrollapi.api.entity.EmployeeEntity;
import com.payrollapi.api.model.EmployeeRequestBody;
 
@Repository
public interface  ApplyLeaveRepository extends CrudRepository<ApplyLeaveEntity,Integer> 
{

	@Query(value = "select * from abit_applyleave", nativeQuery = true)
	Page<ApplyLeaveEntity> listallapplyleavefromdb(Pageable pageable);

}
