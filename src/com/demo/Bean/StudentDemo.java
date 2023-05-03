package com.demo.Bean;

import java.io.Serializable;

public class StudentDemo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private String state;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "StudentDemo [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", mobile=" + mobile + ", state=" + state + "]";
	}

	

	
	

}
