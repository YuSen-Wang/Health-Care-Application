package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Patient;

public interface PatientDAO {

	public List<Patient> getPatients();

	public void savePatient(Patient theCustomer);

	public Patient getPatient(int theId);

	public void deletePatient(int theId);
	
	public List<Patient> searchPatients(String theSearchName);
}
