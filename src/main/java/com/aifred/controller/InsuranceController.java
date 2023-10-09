package com.aifred.controller;

import com.aifred.dto.Hello;
import com.aifred.entity.InsCompany;
import com.aifred.entity.Insurance;
import com.aifred.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class InsuranceController {
	
	@Autowired
	InsuranceService insuranceService;
	
	@GetMapping("/getAllInsurances")
	public ResponseEntity<List<Insurance>> getAllInsurances(Hello requestBody) {
		List<Insurance> insuranceList =  insuranceService.getAllInsurances();
		return new ResponseEntity<List<Insurance>>(insuranceList, HttpStatus.OK);
	}
	
	@GetMapping("/getAllInsCompanies")
	public ResponseEntity<List<InsCompany>> getAllInsCompanies(Hello requestBody) {
		List<InsCompany> insuranceList =  insuranceService.getAllInsCompanies();
		return new ResponseEntity<List<InsCompany>>(insuranceList, HttpStatus.OK);

	}
	
	
	
	

}