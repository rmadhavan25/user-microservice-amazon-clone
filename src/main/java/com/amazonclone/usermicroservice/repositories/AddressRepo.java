package com.amazonclone.usermicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonclone.usermicroservice.models.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {
	
}
