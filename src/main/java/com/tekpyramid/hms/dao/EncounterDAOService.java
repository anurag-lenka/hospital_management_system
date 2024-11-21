package com.tekpyramid.hms.dao;

import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.EncounterDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface EncounterDAOService {
	
	ResponseEntity<ResponseDTO> saveEncounter(EncounterDTO dto);
	ResponseEntity<ResponseDTO> updateEncounter(EncounterDTO dto);
	ResponseEntity<ResponseDTO> deleteEncounter(int altKey);
	ResponseEntity<ResponseDTO> getEncounter(int altKey);
}
