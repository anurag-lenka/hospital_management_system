package com.tekpyramid.hms.data.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class MedicalOrders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alt_key")
	private int altKey;
	
	@Column(name = "number_of_med")
	private int numberOfMed;
	
	@ManyToOne
	@JoinColumn(name = "encounter_id")
	private Encounter encounter;
	
	@ManyToMany
	@JoinTable(name = "medicalorders_items", joinColumns = @JoinColumn(name="medicalorders_id"),inverseJoinColumns = @JoinColumn(name="items_id"))
	@JsonBackReference
	private List<Items> items;
	
	public void addEncounter(Encounter encounter) {
		this.encounter=encounter;
		encounter.addMedOrders(this);
	}
	
	public void addItems(Items items) {
		this.items.add(items);
	}
}
