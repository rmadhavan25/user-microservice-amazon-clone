package com.amazonclone.usermicroservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonclone.usermicroservice.exceptions.UserAlreadyExistsException;
import com.amazonclone.usermicroservice.models.Address;
import com.amazonclone.usermicroservice.models.UserProfile;
import com.amazonclone.usermicroservice.services.UserProfileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(description = "Set of endpoints for creating and updating profile of a user")
public class UserProfileController {
	
	@Autowired
	UserProfileService userProfileService;
	
	//update mail
	@PutMapping("/mail")
	@ApiOperation(value = "function to update email address if email doesn't exist else throws error message")
	public UserProfile updateMail(@ApiParam(value = "Full userProfile model")@RequestBody UserProfile userProfile) throws UserAlreadyExistsException {
		try {
			return userProfileService.updateEmail(userProfile, userProfile.getEmail());
		}
		catch(UserAlreadyExistsException uae) {
			throw new UserAlreadyExistsException(uae.getMessage());
		}
	}
	
	//update phone
	@PutMapping("/phone")
	@ApiOperation(value = "function to update phone number if phone doesn't exist else throws error message")
	public UserProfile updatePhone(@ApiParam(value = "Full userProfile model")@RequestBody UserProfile userProfile) throws UserAlreadyExistsException {
		try {
			return userProfileService.updatePhone(userProfile, userProfile.getPhone());
		}
		catch(UserAlreadyExistsException uae) {
			throw new UserAlreadyExistsException(uae.getMessage());
		}
	
	}
	
	//add new address
	@PostMapping("/address")
	@ApiOperation(value = "function to add a new address")
	public UserProfile addAddress(@ApiParam(value = "Address model")@RequestBody Address address) {
		return userProfileService.setNewUserAddress(address);
	}
	
	@DeleteMapping("/address")
	@ApiOperation(value = "function to delete an address")
	public UserProfile deleteAddress(@ApiParam(value = "Address model")@RequestBody Address address) {
		return userProfileService.deleteUserAddress(address);
	}
	
	@PutMapping("/address")
	@ApiOperation(value = "function to update an address")
	public UserProfile updateAddress(@ApiParam(value = "Address model")@RequestBody Address address) {
		return userProfileService.updateUserAddress(address);
	}
	
	//get user-profile using user-name
	@GetMapping("/userprofile/{userName}")
	@ApiOperation(value = "function to get userProfile using username")
	public UserProfile getUserProfile(@ApiParam(value = "userName of a user")@PathVariable String userName) {
		return userProfileService.getUserProfile(userName);
	}

}
