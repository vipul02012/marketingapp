package com.marketingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entities.Lead;
import com.marketingapp.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLeadById(Long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public Lead findById(Long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		return findById.get();
		
	}

	

}
