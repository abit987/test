package com.payrollapi.api.repositories;

import com.payrollapi.api.entity.userEntity;
import com.payrollapi.api.entity.userEntity;

import java.util.List;

 import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface UserRepository extends CrudRepository<userEntity, Integer> {

	userEntity findByUsername(String username);
 
    @Query(value = "SELECT *  FROM abit_user ", nativeQuery = true)
	Page<userEntity> listallusersfromdb( Pageable pageable);
 
    
    }
