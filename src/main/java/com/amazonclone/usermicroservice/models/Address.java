package com.amazonclone.usermicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private String doorNoAndName;
	private String street;
	private String area;
	private String city;
	private String country;
	private int pincode;
	
}
