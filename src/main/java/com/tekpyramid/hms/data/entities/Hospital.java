package com.tekpyramid.hms.data.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alt_key")
	private int altKey;
	
	@Column(name = "name")
	private String hospitalName;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
	@Column(name = "branches")
	@JsonManagedReference
	private List<Branch> branches;
	
	public void addBranch(Branch branch) {
		branches.add(branch);
		
	}
	
	public void removeBranch(Branch branch) {
		branches.remove(branch);
		branch.setHospital(null);
	}
}
