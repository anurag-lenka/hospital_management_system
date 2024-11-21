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

import com.tekpyramid.hms.data.dto.EncounterDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.EncounterService;

@RestController
public class EncounterController {

	@Autowired
	private EncounterService encounterService;
	
	@PostMapping("/saveEncounter")
	public ResponseEntity<ResponseDTO> saveEncounter(@RequestBody EncounterDTO dto){
		
		return encounterService.saveEncounter(dto);
	}
	
	@PutMapping("/updateEncounter")
	public ResponseEntity<ResponseDTO> updateEncounter(@RequestBody EncounterDTO dto){
	
		return encounterService.updateEncounter(dto);
	}
	
	@DeleteMapping("/deleteEncounter")
	public ResponseEntity<ResponseDTO> deleteEncounter(@RequestHeader int altKey){
		
		return encounterService.deleteEncounter(altKey);
	}
	
	@GetMapping("/getEncounter")
	public ResponseEntity<ResponseDTO> getEncounter(@RequestHeader int altKey){
		
		return encounterService.getEncounter(altKey);
	}
}
