package com.exam.model;

public class jwtResponse {

	private String token;

	public jwtResponse() {
		
	}

	public jwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
