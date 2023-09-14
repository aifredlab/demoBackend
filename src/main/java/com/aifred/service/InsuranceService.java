package com.aifred.service;

import java.util.List;

import com.aifred.entity.InsCompany;
import com.aifred.entity.Insurance;

public interface InsuranceService {
	
	List<Insurance> getAllInsurances();
	
	List<InsCompany> getAllInsCompanies() ;

}
