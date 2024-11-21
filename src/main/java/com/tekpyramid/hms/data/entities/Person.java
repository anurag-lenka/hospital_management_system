package com.tekpyramid.hms.data.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alt_key")
	private int altKey;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	@OneToMany(mappedBy = "person")
	@Column(name = "encounters")
	@JsonManagedReference 
	private List<Encounter> encounters;
	
	public void addEncounter(Encounter encounter) {
		encounters.add(encounter);
	}
}
