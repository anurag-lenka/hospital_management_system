package com.tekpyramid.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.tekpyramid.hms.data.dto.PersonDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("/savePerson")
	public ResponseEntity<ResponseDTO> savePerson(@RequestBody PersonDTO personDTO){
		return personService.savePerson(personDTO);
	}
	
	@PutMapping("/updatePerson")
	public ResponseEntity<ResponseDTO> updatePerson(@RequestBody PersonDTO personDTO){
		return personService.updatePerson(personDTO);
	}
	
	@DeleteMapping("/deletePerson")
	public ResponseEntity<ResponseDTO> deletePerson(@RequestHeader int altKey){
		return personService.deletePerson(altKey);
	}
	
	@GetMapping("/getPerson")
	public ResponseEntity<ResponseDTO> getPerson(@RequestHeader int altKey){
		return personService.getPerson(altKey);
	}
}
