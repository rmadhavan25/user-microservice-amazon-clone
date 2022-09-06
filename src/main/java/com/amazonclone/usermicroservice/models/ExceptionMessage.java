package com.amazonclone.usermicroservice.models;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionMessage {
	private String error;
	private int statusCode;
}
