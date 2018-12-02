package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Medication;


@Repository
public class MedicationDAOImpl implements MedicationDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Medication> getMedications() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Medication> theQuery = 
				currentSession.createQuery("from Medication order by name",
										Medication.class);
		
		// execute query and get result list
		List<Medication> medications = theQuery.getResultList();
				
		// return the results		
		return medications;
	}

	@Override
	public void saveMedication(Medication theMedication) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theMedication);
		
	}

	@Override
	public Medication getMedication(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Medication theMedication = currentSession.get(Medication.class, theId);
		
		return theMedication;
	}

	@Override
	public void deleteMedication(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Medication where id=:medicationId");
		theQuery.setParameter("medicationId", theId);
		
		theQuery.executeUpdate();		
	}

	@Override
	public List<Medication> searchMedications(String theSearchName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery =currentSession.createQuery("from Medication where lower(Name) like :theName or lower(Name) like :theName", Medication.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		}
		else {
			// theSearchName is empty ... so just get all customers
			theQuery =currentSession.createQuery("from Medication", Medication.class);			
		}
		
		// execute query and get result list
		List<Medication> medications = theQuery.getResultList();
				
		// return the results		
		return medications;
		
	}

}












