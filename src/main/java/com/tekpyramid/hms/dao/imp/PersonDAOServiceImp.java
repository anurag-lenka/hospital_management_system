package com.tekpyramid.hms.dao.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.PersonDAOService;
import com.tekpyramid.hms.data.dto.PersonDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.data.entities.Person;
import com.tekpyramid.hms.repository.PersonRepository;
import com.tekpyramid.hms.util.CreateEntities;
import com.tekpyramid.hms.util.ResponseUtil;

@Service
public class PersonDAOServiceImp implements PersonDAOService{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public ResponseEntity<ResponseDTO> savePerson(PersonDTO dto) {

		Person person = CreateEntities.createPerson(dto);
		personRepository.save(person);
		return ResponseUtil.getCreateResponse("Success");
	}

	@Override
	public ResponseEntity<ResponseDTO> updatePerson(PersonDTO dto) {
		
		Optional<Person> byId = personRepository.findById(dto.getAltKey());
		if(byId.isEmpty()) {
			return ResponseUtil.getNotFoundResponse("Resource not found");
		}
		
		Person person = byId.get();
		person.setAge(dto.getAge());
		person.setContactNumber(dto.getContactNumber());
		person.setName(dto.getName());
		personRepository.save(person);
		
		return ResponseUtil.getOkResponse("Updated Successfully");
	}

	@Override
	public ResponseEntity<ResponseDTO> deletePerson(int altKey) {

		personRepository.deleteById(altKey);
		return ResponseUtil.getOkResponse("Deleted Successfully");
	}

	@Override
	public ResponseEntity<ResponseDTO> getPerson(int altKey) {

		Optional<Person> byId = personRepository.findById(altKey);
		System.out.println(byId.get().getName());
		if(byId.isEmpty()) {
			return ResponseUtil.getNotFoundResponse("Resource not found");
		}
		return ResponseUtil.getOkResponse(byId.get());
	}

	
}
