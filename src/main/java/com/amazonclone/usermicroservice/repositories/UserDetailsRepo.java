package com.amazonclone.usermicroservice.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonclone.usermicroservice.models.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer> {
	UserDetails findByUserName(String userName);
	UserDetails findByEmail(String email);
	UserDetails findByPhone(String phone);
}
