package com.aifred.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aifred.entity.Insurance;


public interface InsuranceRepository  extends JpaRepository<Insurance, String>{
	
	List<Insurance> findAll();
	
	

}
