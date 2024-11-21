package com.tekpyramid.hms.dao;

import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.AddressDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface AddressDAOService {
	
	ResponseEntity<ResponseDTO> saveAddress(AddressDTO addressDTO);
	ResponseEntity<ResponseDTO> updateAddress(AddressDTO addressDTO);
	ResponseEntity<ResponseDTO> deleteAddress(int altKey);
	ResponseEntity<ResponseDTO> getAddress(int altKey);
	
}
