package com.example.demo.model;

import java.util.Objects;

public class LoginRequest {
	private String username;
    private String pwd;
    
	public LoginRequest(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}

	public LoginRequest() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pwd, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginRequest other = (LoginRequest) obj;
		return Objects.equals(pwd, other.pwd) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", pwd=" + pwd + "]";
	}
}
