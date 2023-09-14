package com.aifred.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class InsCompany {
	
	@Id
	private String id;
	
	private String name;	

}
