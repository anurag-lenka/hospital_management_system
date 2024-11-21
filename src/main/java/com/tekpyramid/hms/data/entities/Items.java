package com.tekpyramid.hms.data.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alt_key")
	private int altKey;
	
	@Column(name = "name")
	private String itemName;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany(mappedBy = "items")
	@Column(name = "medical_Orders")
	@JsonBackReference
	private List<MedicalOrders> medicalOrders;
	
	public void addMedOrders(MedicalOrders medicalOrders) {
		this.medicalOrders.add(medicalOrders);
		medicalOrders.addItems(this);
	}
	
}
