package com.KrishiKendra.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel {
	
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long Id;
	
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	

}
