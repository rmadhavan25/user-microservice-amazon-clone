package com.amazonclone.usermicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
	private boolean isUser;
	private String issue;
}
