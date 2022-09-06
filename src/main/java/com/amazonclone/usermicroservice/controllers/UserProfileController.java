package com.amazonclone.usermicroservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonclone.usermicroservice.exceptions.UserAlreadyExistsException;
import com.amazonclone.usermicroservice.models.UserProfile;
import com.amazonclone.usermicroservice.services.UserProfileService;

@RestController
public class UserProfileController {
	
	@Autowired
	UserProfileService userProfileService;
	
	//update mail
	@PutMapping("/mail")
	public UserProfile updateMail(@RequestBody UserProfile userProfile) throws UserAlreadyExistsException {
		try {
			return userProfileService.updateEmail(userProfile, userProfile.getEmail());
		}
		catch(UserAlreadyExistsException uae) {
			throw new UserAlreadyExistsException(uae.getMessage());
		}
	}
	
	//update phone
	@PutMapping("/phone")
	public UserProfile updatePhone(@RequestBody UserProfile userProfile) throws UserAlreadyExistsException {
		try {
			return userProfileService.updatePhone(userProfile, userProfile.getPhone());
		}
		catch(UserAlreadyExistsException uae) {
			throw new UserAlreadyExistsException(uae.getMessage());
		}
	
	}
	
	//get userprofile using username
	@GetMapping("/userprofile/{userName}")
	public UserProfile getUserProfile(@PathVariable String userName) {
		return userProfileService.getUserProfile(userName);
	}

}
