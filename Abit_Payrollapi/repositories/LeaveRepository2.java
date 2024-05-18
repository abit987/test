package com.payrollapi.api.repositories;

import com.payrollapi.api.entity.LeaveEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository2 extends CrudRepository<LeaveEntity, Integer> {

 
    @Query(value = "SELECT *  FROM abit_leave ", nativeQuery = true)
	Page<LeaveEntity> listallusersfromdb( Pageable pageable);
 
    
    }
