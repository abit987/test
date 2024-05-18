package com.payrollapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payrollapi.api.model.UpdateUser1;

import com.payrollapi.api.service.UserService;
import com.payrollapi.api.model.UserModel;
 
@RestController
@CrossOrigin
public class UserController 
{

	
	@Autowired
	private UserService userDetailsService;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserModel user) throws Exception 
	{
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	
	@RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody UpdateUser1 user) throws Exception 
	{
		return ResponseEntity.ok(userDetailsService.update(user));
	}
	
	
	
	@RequestMapping(value = "/listallusersfromdb", method = RequestMethod.GET)
	public ResponseEntity<?> listallusersfromdb(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception 
	{
		return ResponseEntity.ok(userDetailsService.listallusersfromdb(pageNumber, size));
	}
	
	
	
}
