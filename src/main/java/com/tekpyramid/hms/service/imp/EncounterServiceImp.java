package com.tekpyramid.hms.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.EncounterDAOService;
import com.tekpyramid.hms.data.dto.EncounterDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.EncounterService;

@Service
public class EncounterServiceImp implements EncounterService{

	@Autowired
	private EncounterDAOService encounterDAOService;
	
	@Override
	public ResponseEntity<ResponseDTO> saveEncounter(EncounterDTO dto) {

		
		return encounterDAOService.saveEncounter(dto);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateEncounter(EncounterDTO dto) {
		
		return encounterDAOService.updateEncounter(dto);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteEncounter(int altKey) {

		return encounterDAOService.deleteEncounter(altKey);
	}

	@Override
	public ResponseEntity<ResponseDTO> getEncounter(int altKey) {

		return encounterDAOService.getEncounter(altKey);
	}

	

}
