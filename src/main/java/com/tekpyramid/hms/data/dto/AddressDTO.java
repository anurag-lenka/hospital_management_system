package com.tekpyramid.hms.data.dto;


import lombok.Data;

@Data
public class AddressDTO {

	private int altKey;
	private String city;
	private String pinCode;
	private String state;
	private int branchId;
	
}
