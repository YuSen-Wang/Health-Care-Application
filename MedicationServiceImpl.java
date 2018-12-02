package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.MedicationDAO;
import com.luv2code.springdemo.entity.Medication;


@Service
public class MedicationServiceImpl implements MedicationService {

	// need to inject customer dao
	@Autowired
	private MedicationDAO medicationDAO;
	
	@Override
	@Transactional
	public List<Medication> getMedications() {
		return medicationDAO.getMedications();
	}

	@Override
	@Transactional
	public void saveMedication(Medication theMedication) {

		medicationDAO.saveMedication(theMedication);
	}

	@Override
	@Transactional
	public Medication getMedication(int theId) {
		
		return medicationDAO.getMedication(theId);
	}

	@Override
	@Transactional
	public void deleteMedication(int theId) {
		
		medicationDAO.deleteMedication(theId);
	}

	@Override
	@Transactional
	public List<Medication> searchMedications(String theSearchName) {

		return medicationDAO.searchMedications(theSearchName);
	}
}




