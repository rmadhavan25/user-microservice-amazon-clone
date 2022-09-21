package com.amazonclone.usermicroservice.models;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserProfile {
	public UserProfile(String userName2, String email2, String phone2) {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String email;
	private String phone;
	
	@OneToMany(mappedBy = "userProfile")
	@JsonManagedReference
	private List<Address> addresses;
}
