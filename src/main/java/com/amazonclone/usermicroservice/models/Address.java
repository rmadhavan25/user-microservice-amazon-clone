package com.amazonclone.usermicroservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String doorNoAndName;
	private String street;
	private String area;
	private String city;
	private String country;
	private int pincode;
	
	@ManyToOne
    @JoinColumn(name="user_profile_id")
	@JsonBackReference
	private UserProfile userProfile;
	
}
