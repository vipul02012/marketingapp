package com.marketingapp.service;

import java.util.List;

import com.marketingapp.entities.Lead;

public interface LeadService {
	public void saveLead(Lead lead);
	public List<Lead> getAllLeads();
	public void deleteLeadById(Long id);
	public Lead findById(Long id);
	
}
