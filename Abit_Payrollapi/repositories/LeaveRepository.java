package com.payrollapi.api.repositories;


import com.payrollapi.api.entity.LeaveEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payrollapi.api.entity.LeaveEntity;
import com.payrollapi.api.model.LeaveRequestBody;

@Repository
public interface  LeaveRepository extends CrudRepository<LeaveEntity,Integer> 
{

	@Query(value = "select * from  abit_leave", nativeQuery = true)
    //	Page<LeaveEntity> listallleavefromdb(Pageable pageable);

	Page<LeaveEntity> listallleavefromdb(Pageable pageable);

	@Override
	  LeaveEntity save(LeaveEntity leaveEntity);

	



}
