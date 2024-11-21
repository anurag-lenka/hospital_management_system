package com.tekpyramid.hms.dao.imp;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.EncounterDAOService;
import com.tekpyramid.hms.dao.MedicalOrdersDAOService;
import com.tekpyramid.hms.dao.PersonDAOService;
import com.tekpyramid.hms.data.dto.EncounterDTO;
import com.tekpyramid.hms.data.dto.ItemsDTO;
import com.tekpyramid.hms.data.dto.MedicalOrdersDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.data.entities.Branch;
import com.tekpyramid.hms.data.entities.Encounter;
import com.tekpyramid.hms.data.entities.Person;
import com.tekpyramid.hms.repository.BranchRepository;
import com.tekpyramid.hms.repository.EncounterRepository;
import com.tekpyramid.hms.repository.MedicalOrdersRepository;
import com.tekpyramid.hms.repository.PersonRepository;
import com.tekpyramid.hms.util.CreateEntities;
import com.tekpyramid.hms.util.ResponseUtil;

@Service
public class EncounterDAOServiceImp implements EncounterDAOService{

	@Autowired
	private EncounterRepository encounterRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	
	@Override
	public ResponseEntity<ResponseDTO> saveEncounter(EncounterDTO dto) {

		Branch branch = branchRepository.findById(dto.getBranchId()).get();
		Person person = personRepository.findById(dto.getPersonId()).get();
		
		Encounter encounter = CreateEntities.createEncounter(dto);
		encounter.addBranch(branch);
		encounter.addPerson(person);
		
		encounterRepository.save(encounter);
		return ResponseUtil.getCreateResponse("Success");
	}

	@Override
	public ResponseEntity<ResponseDTO> updateEncounter(EncounterDTO dto) {
		
		Optional<Encounter> byId = encounterRepository.findById(dto.getAltKey());
		if(byId.isEmpty()) {
			return ResponseUtil.getNotFoundResponse("Resource not found");
		}
		
		Encounter encounter = byId.get();
		encounter.setDoctorName(dto.getDoctorName());
		encounterRepository.save(encounter);
		return ResponseUtil.getOkResponse(encounter);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteEncounter(int altKey) {
		
		encounterRepository.deleteById(altKey);
		
		return ResponseUtil.getOkResponse("Success");
	}

	@Override
	public ResponseEntity<ResponseDTO> getEncounter(int altKey) {
		Optional<Encounter> byId = encounterRepository.findById(altKey);
		if(byId.isEmpty()) {
			return ResponseUtil.getNotFoundResponse("Resource not found");
		}
		return ResponseUtil.getOkResponse(byId.get());
	}

	

}
