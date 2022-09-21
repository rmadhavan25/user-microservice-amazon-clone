package com.amazonclone.usermicroservice.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonclone.usermicroservice.exceptions.UserAlreadyExistsException;
import com.amazonclone.usermicroservice.models.Address;
import com.amazonclone.usermicroservice.models.UserDetails;
import com.amazonclone.usermicroservice.models.UserProfile;
import com.amazonclone.usermicroservice.repositories.AddressRepo;
import com.amazonclone.usermicroservice.repositories.UserDetailsRepo;
import com.amazonclone.usermicroservice.repositories.UserProfileRepo;

@Service
public class UserProfileService {
	
	@Autowired
	UserDetailsRepo userDetailsRepo;
	
	@Autowired
	UserProfileRepo userProfileRepo;
	
	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	UserService userService;
	

	
	public UserProfile updateEmail(UserProfile userProfile,String newEmailId) throws UserAlreadyExistsException {
		//check if the given mail exists
		if(userService.isExistingEmail(newEmailId)) {
			throw new UserAlreadyExistsException("email already taken. Try using another mail");
		}
		else {
			
			//updating userDetails
			UserDetails userDetails = userDetailsRepo.findByUserName(userProfile.getUserName());
			userDetails.setEmail(newEmailId);
			userDetailsRepo.save(userDetails);
			
			//updating profile
			userProfile = userProfileRepo.findByUserName(userProfile.getUserName());
			userProfile.setEmail(newEmailId);
			return userProfileRepo.save(userProfile);
		}
	}
	
	public UserProfile updatePhone(UserProfile userProfile,String newPhoneNumber) throws UserAlreadyExistsException {
		//check if the given phone number exists
		if(userService.isExistingPhone(newPhoneNumber)) {
			throw new UserAlreadyExistsException("Phone number already taken. Try using another phone number");
		}
		else {
			
			//updating userDetails
			UserDetails userDetails = userDetailsRepo.findByUserName(userProfile.getUserName());
			userDetails.setPhone(newPhoneNumber);
			userDetailsRepo.save(userDetails);
			
			//updating profile
			userProfile = userProfileRepo.findByUserName(userProfile.getUserName());
			userProfile.setPhone(newPhoneNumber);
			return userProfileRepo.save(userProfile);
		}
	}
	
	//get user profile by user-name
	public UserProfile getUserProfile(String UserName) {
		return userProfileRepo.findByUserName(UserName);
	}
	
	//add new address
	public UserProfile setNewUserAddress(Address address) {
		
		addressRepo.save(address);
		return getUserProfile(address.getUserProfile().getUserName());
	}
	
	//update address
	public UserProfile updateUserAddress(Address address) {
		addressRepo.save(address);
		return getUserProfile(address.getUserProfile().getUserName());
	}
	
	//delete address
	public UserProfile deleteUserAddress(Address address) {
		
		UserProfile userProfile_of_deleted_address = address.getUserProfile();
		
		addressRepo.deleteById(address.getId());
		
		return getUserProfile(userProfile_of_deleted_address.getUserName());
	}
	
	//save a new user profile
	public void saveUserProfile(UserDetails userDetails) {
		UserProfile userProfile = new UserProfile();
		userProfile.setUserName(userDetails.getUserName());
		userProfile.setEmail(userDetails.getEmail());
		userProfile.setPhone(userDetails.getPhone());
		System.out.println(userProfile.toString());
		userProfileRepo.save(userProfile);
	}
}
