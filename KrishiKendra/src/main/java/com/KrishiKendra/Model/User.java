package com.KrishiKendra.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Data")
public class User extends BaseModel{
	String firstName, lastName, villageName;
	String mobileNumber;
	 @JsonProperty
	    @Override
	    public long getId() {
	        return super.getId();
	    }	
	public String getFirstName() {
		return firstName;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public User(String firstName, String lastName, String villageName, String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.villageName = villageName;
		this.mobileNumber = mobileNumber;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	

   
}
