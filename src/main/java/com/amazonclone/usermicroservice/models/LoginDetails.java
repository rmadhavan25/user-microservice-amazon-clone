package com.amazonclone.usermicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDetails {

	private String userName;
	private String password;
		
}
