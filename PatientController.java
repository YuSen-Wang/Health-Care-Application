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

import com.luv2code.springdemo.entity.Patient;
import com.luv2code.springdemo.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	// need to inject our customer service
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/list")
	public String listPatients(Model theModel) {
		
		// get customers from the service
		List<Patient> thePatients = patientService.getPatients();
				
		// add the customers to the model
		theModel.addAttribute("patients", thePatients);
		
		return "list-patients";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Patient thePatient = new Patient();
		
		theModel.addAttribute("patient", thePatient);
		
		return "patient-form";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@Valid @ModelAttribute("patient") Patient thePatient,
			BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()){
			return "patient-form";
		}
		
		else{
		// save the customer using our service
		patientService.savePatient(thePatient);	
		
		return "redirect:/patient/list";}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("patientId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Patient thePatient = patientService.getPatient(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("patient", thePatient);
		
		// send over to our form		
		return "patient-form";
	}
	
	@GetMapping("/delete")
	public String deletePatient(@RequestParam("patientId") int theId) {
		
		// delete the customer
		patientService.deletePatient(theId);
		
		return "redirect:/patient/list";
	}

	@PostMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {

		// search customers from the service
		List<Patient> thePatients = patientService.searchPatients(theSearchName);
				
		// add the customers to the model
		theModel.addAttribute("patients", thePatients);

		return "list-patients";		
	}

}










