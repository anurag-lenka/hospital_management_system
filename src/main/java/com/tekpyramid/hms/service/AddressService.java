package com.tekpyramid.hms.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.AddressDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface AddressService {

	ResponseEntity<ResponseDTO> saveAddress(AddressDTO addressDTO);
	ResponseEntity<ResponseDTO> updateAddress(AddressDTO addressDTO);
	ResponseEntity<ResponseDTO> deleteAddress(int altKey);
	ResponseEntity<ResponseDTO> getAddress(int altKey);
}
