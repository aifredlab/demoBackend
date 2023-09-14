package com.aifred.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aifred.entity.InsCompany;
import com.aifred.entity.Insurance;
import com.aifred.repository.InsCompanyRepository;
import com.aifred.repository.InsuranceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService{
	
	private final InsuranceRepository insuranceRepository;
	
	private final InsCompanyRepository insCompanyRepository;
	
	public List<Insurance> getAllInsurances() {
		return insuranceRepository.findAll();
	}
	
	public List<InsCompany> getAllInsCompanies() {
		return insCompanyRepository.findAll();
		
		
	}
	
	
	
	

}
