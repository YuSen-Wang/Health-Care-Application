package com.luv2code.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Medication;
import com.luv2code.springdemo.service.MedicationService;

@Controller
@RequestMapping("/medication")
public class MedicationController {

	// need to inject our customer service
	@Autowired
	private  MedicationService medicationService;
	
	@GetMapping("/list")
	public String listMedications(Model theModel) {
		
		// get customers from the service
		List<Medication> theMedications = medicationService.getMedications();
				
		// add the customers to the model
		  theModel.addAttribute("medications", theMedications);
		
		return "list-medications";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Medication theMedication = new Medication();
		
		theModel.addAttribute("medication", theMedication);
		
		return "medication-form";
	}
	
	@PostMapping("/saveMedication")
	public String saveMedication(@Valid @ModelAttribute("medication") Medication theMedication,
			BindingResult theBindingResult) {
		
		// save the customer using our service
		if(theBindingResult.hasErrors()){
			return "medication-form";
		}
		else{
		medicationService.saveMedication(theMedication);	
		
		return "redirect:/medication/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("medicationId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Medication theMedication = medicationService.getMedication(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("medication", theMedication);
		
		// send over to our form		
		return "medication-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("medicationId") int theId) {
		
		// delete the customer
		medicationService.deleteMedication(theId);
		
		return "redirect:/medication/list";
	}

	@PostMapping("/search")
	public String searchMedications(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {

		// search customers from the service
		List<Medication> theMedications = medicationService.searchMedications(theSearchName);
				
		// add the customers to the model
		theModel.addAttribute("medications", theMedications);

		return "list-medications";		
	}

}










