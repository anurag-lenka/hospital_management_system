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

import com.tekpyramid.hms.data.dto.HospitalDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.HospitalService;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@PostMapping("/saveHos")
	public ResponseEntity<ResponseDTO> saveHospital(@RequestBody HospitalDTO hospitalDTO){
		
		return hospitalService.saveHospital(hospitalDTO);
	}
	
	@PutMapping("/updateHos")
	public ResponseEntity<ResponseDTO> updateHospital(@RequestBody HospitalDTO hospitalDTO){
		
		return hospitalService.updateHospital(hospitalDTO);
	}
	
	@DeleteMapping("/deleteHos")
	public ResponseEntity<ResponseDTO> deleteHospital(@RequestHeader int altKey){
		
		return hospitalService.deleteHospital(altKey);
	}
	
	@GetMapping("/getHos")
	public ResponseEntity<ResponseDTO> getHospital(@RequestHeader int altKey){
		
		return hospitalService.getHospital(altKey);
	}
}
