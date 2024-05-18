package com.payrollapi.api.service;

import com.payrollapi.api.model.UserModel;

import java.util.ArrayList;
import com.payrollapi.api.entity.userEntity;
import com.payrollapi.api.model.UpdateUser1;
import com.payrollapi.api.model.UpdateUser2;
import com.payrollapi.api.model.UserModel;
import com.payrollapi.api.model.UserIdRequest;
 
import com.payrollapi.api.repositories.UserRepository;

import utils.ccputil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
 
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;
 
    
    public userEntity save(UserModel user) 
    {    
    	 
        userEntity newUser = new userEntity();
        newUser.setUsername(user.getUsername());
        //Encrypt Username for Password 
        System.out.println(bcryptEncoder.encode(user.getPrnNumber()));
        newUser.setPassword(bcryptEncoder.encode(user.getPrnNumber()));
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmailId(user.getEmailId());
       
        newUser.setUsername(user.getUsername());
       
        newUser.setIsActive(user.getIsActive());
        newUser.setIsApproved(user.getIsAprroved());
        newUser.setModifiedBy(user.getModifiedBy());
        newUser.setModifiedDate(user.getModifiedDate());
        newUser.setCreatedBy(user.getCreatedBy());
        newUser.setCreatedDate(user.getCreatedDate());
      
        String personalEmail = user.getEmailId();
        String officialEmail =user.getWorkEmail();        
     
      
        
         
        return userDao.save( newUser);
      //  return null;
    }
    
     
    
   	
    public userEntity update(UpdateUser1 user) {
        userEntity newUser = new userEntity();
        newUser.setUserId(user.getUserId());
        newUser.setUsername(user.getUsername());
        //Encrypt Username for Password 
        newUser.setPassword(bcryptEncoder.encode(user.getPrnNumber()));
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmailId(user.getEmailId());
      
        newUser.setUsername(user.getUsername());
      
        newUser.setIsActive(user.getIsActive());
     
        newUser.setIsApproved(user.getIsAprroved());
        newUser.setModifiedBy(user.getModifiedBy());
        newUser.setModifiedDate(user.getModifiedDate());        
       
        return userDao.save(newUser);
    }
	 
	public Page<userEntity> listallusersfromdb( int pageNumber,int size) {
		  Pageable pageable = PageRequest.of(pageNumber, size );
				  return		userDao.listallusersfromdb(pageable); 
						
					}




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
  
	
}
