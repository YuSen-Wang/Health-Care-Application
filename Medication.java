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
@Table(name="medication")
public class Medication {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotNull
	@Size(min=1, message="name is required")
	private String name;
	
	@Column(name="inventory")
	private String inventory;
	
	@Column(name="quatity")
	private String quatity;
	


	public Medication() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getQuatity() {
		return quatity;
	}

	public void setQuatity(String quatity) {
		this.quatity = quatity;
	}

	@Override
	public String toString() {
		return "Medication [id=" + id + ", Name=" + name + ", Inventory=" + inventory + ", Quantity=" + quatity + "]";
	}



	
	
		
}





