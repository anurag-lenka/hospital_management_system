package com.tekpyramid.hms.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.PersonDAOService;
import com.tekpyramid.hms.data.dto.PersonDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.PersonService;

@Service
public class PersonServiceImp implements PersonService{

	@Autowired
	private PersonDAOService personDAOService;
	
	@Override
	public ResponseEntity<ResponseDTO> savePerson(PersonDTO personDTO) {

		return personDAOService.savePerson(personDTO);
	}

	@Override
	public ResponseEntity<ResponseDTO> updatePerson(PersonDTO personDTO) {

		return personDAOService.updatePerson(personDTO);
	}

	@Override
	public ResponseEntity<ResponseDTO> deletePerson(int altKey) {
		
		return personDAOService.deletePerson(altKey);
	}

	@Override
	public ResponseEntity<ResponseDTO> getPerson(int altKey) {

		return personDAOService.getPerson(altKey);
	}


}
