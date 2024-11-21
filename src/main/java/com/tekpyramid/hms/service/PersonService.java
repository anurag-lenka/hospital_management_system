package com.tekpyramid.hms.service;


import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.PersonDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface PersonService {
	
	ResponseEntity<ResponseDTO> savePerson(PersonDTO personDTO);
	ResponseEntity<ResponseDTO> updatePerson(PersonDTO personDTO);
	ResponseEntity<ResponseDTO> deletePerson(int altKey);
	ResponseEntity<ResponseDTO> getPerson(int altKey);
}
