package com.aifred.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aifred.entity.InsCompany;

public interface InsCompanyRepository extends JpaRepository<InsCompany, String>{
	
	List<InsCompany> findAll();
	

}
