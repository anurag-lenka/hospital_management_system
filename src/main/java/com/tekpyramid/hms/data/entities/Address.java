package com.tekpyramid.hms.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alt_key")
	private int altKey;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pin_code")
	private String pinCode;
	
	@Column(name = "state")
	private String state;
	
	@OneToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;
	
	public void addBranch(Branch branch) {
		this.branch=branch;
		branch.addAddress(this);;
	}
	
	public void removeBranch() {
		this.branch=null;
		branch.setAddress(null);
	}
	
	
}
