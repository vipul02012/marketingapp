package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.Dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.repositories.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	
//	http://localhost:8080/api/leads
	
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	
	@PostMapping
	public void createLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
//	http://localhost:8080/api/leads/1
	
	@DeleteMapping("/{id}")
	public void deleteLead(@PathVariable("id") Long id) {
		leadRepo.deleteById(id);
	}
	
//	http://localhost:8080/api/leads/1
	
	@PutMapping("/{id}")
	public void updateLead(@RequestBody LeadDto dto, @PathVariable("id") Long id) {
		Lead ld = new Lead();
		ld.setId(id);
		ld.setFirstName(dto.getFirstName());
		ld.setLastName(dto.getLastName());
		ld.setEmail(dto.getEmail());
		ld.setMobile(dto.getMobile());
		leadRepo.save(ld);
	}
}
