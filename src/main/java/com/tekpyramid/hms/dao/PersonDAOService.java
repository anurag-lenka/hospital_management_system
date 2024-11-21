package com.tekpyramid.hms.dao;

import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.PersonDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface PersonDAOService {

	ResponseEntity<ResponseDTO> savePerson(PersonDTO dto);
	ResponseEntity<ResponseDTO> updatePerson(PersonDTO dto);
	ResponseEntity<ResponseDTO> deletePerson(int altKey);
	ResponseEntity<ResponseDTO> getPerson(int altKey);
}
