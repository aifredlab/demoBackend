package com.aifred.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Insurance {
	
	@Id
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String insId;

}
