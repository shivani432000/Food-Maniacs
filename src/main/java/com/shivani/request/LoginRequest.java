package com.shivani.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//both @getters and @setters comes in @data annotation
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String email;
	private String password;
}
