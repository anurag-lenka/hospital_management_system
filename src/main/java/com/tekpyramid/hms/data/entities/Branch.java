package com.tekpyramid.hms.data.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alt_key")
	private int altKey;
	
	@Column(name = "name")
	private String branchName;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@OneToOne(mappedBy = "branch",cascade = CascadeType.ALL)
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "hospital_id")
	@JsonBackReference
	private Hospital hospital;
	
	@OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
	@Column(name = "encounters")
	@JsonManagedReference
	private List<Encounter> encounters;
	
	public void addHos(Hospital hospital) {
		this.hospital=hospital;
		hospital.addBranch(this);
	}
	
	public void addAddress(Address address) {
		this.address=address;
	}
	
	public void addEncounter(Encounter encounter) {
		encounters.add(encounter);
	}
	
}
