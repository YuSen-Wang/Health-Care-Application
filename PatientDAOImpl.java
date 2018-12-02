package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Patient> getPatients() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Patient> theQuery = 
				currentSession.createQuery("from Patient order by lastName",
											Patient.class);
		
		// execute query and get result list
		List<Patient> patients = theQuery.getResultList();
				
		// return the results		
		return patients;
	}

	@Override
	public void savePatient(Patient thePatient) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate  
		currentSession.saveOrUpdate(thePatient);
		
	}

	@Override
	public Patient getPatient(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Patient thePatient = currentSession.get(Patient.class, theId);
		
		return  thePatient;
	}

	@Override
	public void deletePatient(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Patient where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}

	@Override
	public List<Patient> searchPatients(String theSearchName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery =currentSession.createQuery("from Patient where lower(firstName) like :theName or lower(lastName) like :theName", Patient.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		}
		else {
			// theSearchName is empty ... so just get all customers
			theQuery =currentSession.createQuery("from Patient", Patient.class);			
		}
		
		// execute query and get result list
		List<Patient> patients = theQuery.getResultList();
				
		// return the results		
		return patients;
		
	}

}












