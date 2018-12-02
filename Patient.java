package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="first_name")  // make sure the input is valid
	@NotNull
	@Size(min=1, message="first name is required")  // giving immediate feedback 
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	@Size(min=1, message="last name is required")
	private String lastName;
	
	@Column(name="email")
	private String email;
	

	@Column(name="weight")
	private String weight;
	
	@Column(name="blood_pressure")
	private String bloodPressure;
	
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getbloodPressure() {
		return bloodPressure;
	}

	public void setbloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public Patient() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", weight=" + weight + ", bloodPressure=" + bloodPressure + "]";
	}

	
	
		
}





