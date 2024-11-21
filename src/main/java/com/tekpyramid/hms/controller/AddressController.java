package com.tekpyramid.hms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.tekpyramid.hms.data.dto.AddressDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseDTO> saveAddress(@RequestBody AddressDTO addressDTO){
		
		return addressService.saveAddress(addressDTO);
	}
	
	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseDTO> updateAddress(@RequestBody AddressDTO addressDTO){
		
		return addressService.updateAddress(addressDTO);
	}
	
	@DeleteMapping("/deleteAddress")
	public ResponseEntity<ResponseDTO> deleteAddress(@RequestHeader int altKey){
		
		return addressService.deleteAddress(altKey);
	}
	
	@GetMapping("/getAddress")
	public ResponseEntity<ResponseDTO> getAddress(@RequestHeader int altKey){
		
		return addressService.getAddress(altKey);
	}
}
