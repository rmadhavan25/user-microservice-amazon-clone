package com.amazonclone.usermicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonclone.usermicroservice.models.UserProfile;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Integer> {
	UserProfile findByUserName(String userName);
}
