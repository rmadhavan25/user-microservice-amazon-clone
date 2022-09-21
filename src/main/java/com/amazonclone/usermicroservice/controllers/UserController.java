package com.amazonclone.usermicroservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonclone.usermicroservice.exceptions.UserAlreadyExistsException;
import com.amazonclone.usermicroservice.models.LoginDetails;
import com.amazonclone.usermicroservice.models.LoginResponse;
import com.amazonclone.usermicroservice.models.UserDetails;
import com.amazonclone.usermicroservice.services.UserProfileService;
import com.amazonclone.usermicroservice.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "endpoints for register,login")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@PostMapping("/register")
	@ApiOperation(value = "function to register new user using details provided by user")
	public UserDetails registerNewUser(@RequestBody UserDetails userDetails) throws UserAlreadyExistsException {
		try {
			if(!userService.isExistingUser(userDetails)) {
				UserDetails newUser = userService.saveNewUser(userDetails);
				userProfileService.saveUserProfile(newUser);
				return newUser;
			}
				
		}
		catch(UserAlreadyExistsException uae) {
			throw new UserAlreadyExistsException(uae.getMessage());
		}
		return null;
	}
	
	@PostMapping("/login")
	@ApiOperation(value = "function to login existing user. Checks the for valid credentials")
	public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginDetails loginDetails) {
		
		ResponseEntity<LoginResponse> response;
		UserDetails userDetails = userService.getUser(loginDetails);
		
		if(userDetails!=null) {
			if(userService.isValidPassword(userDetails.getPassword(), loginDetails.getPassword())) {
				response = new ResponseEntity<LoginResponse>(new LoginResponse(true, "No issue"), HttpStatus.OK);
			}
			else {
				response = new ResponseEntity<LoginResponse>(new LoginResponse(false, "Incorrect password"), HttpStatus.FORBIDDEN);
				
			}
			return response;
		}
		
		response = new ResponseEntity<LoginResponse>(new LoginResponse(false, "username does not exist"), HttpStatus.FORBIDDEN);
		return response;
	}
	
}
