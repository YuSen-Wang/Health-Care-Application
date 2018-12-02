package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Medication;


public interface MedicationDAO {

	public List<Medication> getMedications();

	public void saveMedication(Medication theMedication);

	public Medication getMedication(int theId);

	public void deleteMedication(int theId);
	
	public List<Medication> searchMedications(String theSearchName);
}
