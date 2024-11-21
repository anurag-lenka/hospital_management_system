package com.tekpyramid.hms.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.AddressDAOService;
import com.tekpyramid.hms.data.dto.AddressDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.AddressService;

@Service
public class AddressServiceImp implements AddressService{

	@Autowired
	private AddressDAOService addressDAOService;
	
	@Override
	public ResponseEntity<ResponseDTO> saveAddress(AddressDTO addressDTO) {

		return addressDAOService.saveAddress(addressDTO);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateAddress(AddressDTO addressDTO) {

		return addressDAOService.updateAddress(addressDTO);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteAddress(int altKey) {

		return addressDAOService.deleteAddress(altKey);
	}

	@Override
	public ResponseEntity<ResponseDTO> getAddress(int altKey) {

		return addressDAOService.getAddress(altKey);
	}

}
