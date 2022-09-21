package com.amazonclone.usermicroservice.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonclone.usermicroservice.exceptions.UserAlreadyExistsException;
import com.amazonclone.usermicroservice.models.LoginDetails;
import com.amazonclone.usermicroservice.models.UserDetails;
import com.amazonclone.usermicroservice.repositories.UserDetailsRepo;

@Service
public class UserService {
	
	@Autowired
	UserDetailsRepo userDetailsRepo;
	

	//saving a new user to database
	public UserDetails saveNewUser(UserDetails userDetails) {
		return userDetailsRepo.save(userDetails);
		
	}
	
	//finding user based on login credentials:used to catch invalid user
	public UserDetails getUser(LoginDetails loginDetails) {
		UserDetails user = userDetailsRepo.findByUserName(loginDetails.getUserName());
		if(user!=null) {
			return user;
		}
		return null;
	}
	
	//checking the password
	public boolean isValidPassword(String correctPassword,String enteredPassword) {
		return correctPassword.equals(enteredPassword);
	}
	
	
	//checking existing info in-order to maintain unique information for each user
	public boolean isExistingUserName(String userName) {
		return userDetailsRepo.findByUserName(userName)!=null;
	}
	
	public boolean isExistingEmail(String email) {
		return userDetailsRepo.findByEmail(email)!=null;
	}
	
	public boolean isExistingPhone(String phone) {
		return userDetailsRepo.findByPhone(phone)!=null;
	}
	
	public boolean isExistingUser(UserDetails userDetails) throws UserAlreadyExistsException {
		if(isExistingUserName(userDetails.getUserName())) {
			throw new UserAlreadyExistsException("Username already exists");
		}
		
		if(isExistingEmail(userDetails.getEmail())) {
			throw new UserAlreadyExistsException("User with this email-Id already exists");
		}
		
		if(isExistingPhone(userDetails.getPhone())) {
			throw new UserAlreadyExistsException("User with this phone number already exists");
		}
		return false;
	}

}
