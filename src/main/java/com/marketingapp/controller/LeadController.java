package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.Dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.service.LeadService;
import com.marketingapp.utility.EmailService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadServ;
	
	@Autowired
	private EmailService emailServ;
	
	//https://localhost:8080/create
	@RequestMapping("/create")
	public String viewCreatedLead() {
		return "create_lead";
		
	}
	
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute Lead lead, Model model) {
		leadServ.saveLead(lead);
		emailServ.sendEmail(lead.getEmail(), "MarketingApp", "Thankyou for Registering yourself in our portal");
		model.addAttribute("msg", "Registration data is saved..");
		return "create_lead";
	}
	
//	@RequestMapping("/saveLead")
//	public String saveLead(
//			@RequestParam("firstName") String firstName,
//			@RequestParam("lastName") String lastName,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") long mobile
//			) {
//		Lead lead = new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		leadServ.saveLead(lead);
//		return "create_lead";
//	}
	
//	@RequestMapping("/saveLead") 
//	public String saveLead(LeadDto leadDto) {
//		Lead lead = new Lead();
//		lead.setFirstName(leadDto.getFirstName());
//		lead.setLastName(leadDto.getLastName());
//		lead.setEmail(leadDto.getEmail());
//		lead.setMobile(leadDto.getMobile());
//		leadServ.saveLead(lead);
//		return "create_lead";
//	}
	
	//https://localhost:8080/listAll
	@RequestMapping("/listAll")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadServ.getAllLeads();
		model.addAttribute("leads", leads);
		return "get_leads";
	}
	
	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id") Long id, Model model) {
		leadServ.deleteLeadById(id);
		List<Lead> leads = leadServ.getAllLeads();
		model.addAttribute("leads", leads);
		return "get_leads";
	}
	
	@RequestMapping("/update")
	public String findLeadById(@RequestParam("id") Long id, Model model) {
		Lead lead = leadServ.findById(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateLead(LeadDto dto, Model model) {
		Lead ld = new Lead();
		ld.setId(dto.getId());
		ld.setFirstName(dto.getFirstName());
		ld.setLastName(dto.getLastName());
		ld.setEmail(dto.getEmail());
		ld.setMobile(dto.getMobile());
		leadServ.saveLead(ld);
		
		List<Lead> leads = leadServ.getAllLeads();
		model.addAttribute("leads", leads);
		return "get_leads";
	}
}
