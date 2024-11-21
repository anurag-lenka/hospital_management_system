package com.tekpyramid.hms.data.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Encounter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alt_key")
	private int altKey;
	
	@Column(name = "visit_date")
	private Date visitDate;
	
	@Column(name = "doctor_name")
	private String doctorName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	@JsonBackReference
	private Person person;
	
	@OneToMany(mappedBy = "encounter",cascade = CascadeType.ALL)
	@Column(name = "medical_orders")
	private List<MedicalOrders> medicalOrders;
	
	@ManyToOne
	@JoinColumn(name = "branch_id")
	@JsonBackReference
	private Branch branch;
	
	public void addBranch(Branch branch) {
		this.branch=branch;
		branch.addEncounter(this);
	}
	
	public void addPerson(Person person) {
		this.person=person;
		person.addEncounter(this);
	}
	
	public void addMedOrders(MedicalOrders medicalOrders) {
		medicalOrders.setEncounter(this);
	}
}
