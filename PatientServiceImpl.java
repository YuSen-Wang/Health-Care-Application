package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.PatientDAO;
import com.luv2code.springdemo.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	// need to inject customer dao
	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	@Transactional(readOnly=true)  //To manage transaction for us
	public List<Patient> getPatients() {
		return patientDAO.getPatients();
	}

	@Override
	@Transactional(readOnly=false)
	public void savePatient(Patient thePatient) {

		patientDAO.savePatient(thePatient);
	}

	@Override
	@Transactional(readOnly=true)
	public Patient getPatient(int theId) {
		
		return patientDAO.getPatient(theId);
	}

	@Override
	@Transactional(readOnly=false)
	public void deletePatient(int theId) {
		
		patientDAO.deletePatient(theId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Patient> searchPatients(String theSearchName) {

		return patientDAO.searchPatients(theSearchName);
	}
}




