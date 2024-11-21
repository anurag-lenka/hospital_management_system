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

import com.tekpyramid.hms.data.dto.MedicalOrdersDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.MedicalOrdersService;

@RestController
public class MedicalOrderController {

	@Autowired
	private MedicalOrdersService medicalOrdersService;
	
	@PostMapping("/saveMedOrders")
	public ResponseEntity<ResponseDTO> saveMedOrders(@RequestBody MedicalOrdersDTO dto){
		
		return medicalOrdersService.saveMedicalOrders(dto);
	}
	
	@PutMapping("/updateMedOrders")
	public ResponseEntity<ResponseDTO> updateMedOrders(@RequestBody MedicalOrdersDTO dto){
		return medicalOrdersService.updateMedicalOrders(dto);
	}
	
	@DeleteMapping("/deleteMedOrders")
	public ResponseEntity<ResponseDTO> deleteMedOrders(@RequestHeader int altKey){
		return medicalOrdersService.deleteMedicalOrders(altKey);
	}
	
	@GetMapping("/getMedOrders")
	public ResponseEntity<ResponseDTO> getMedOrders(@RequestHeader int altKey){
		return medicalOrdersService.getMedicalOrders(altKey);
	}
}
