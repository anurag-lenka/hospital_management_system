package com.tekpyramid.hms.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.EncounterDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface EncounterService {

	ResponseEntity<ResponseDTO> saveEncounter(EncounterDTO dto);
	ResponseEntity<ResponseDTO> updateEncounter(EncounterDTO dto);
	ResponseEntity<ResponseDTO> deleteEncounter(int altKey);
	ResponseEntity<ResponseDTO> getEncounter(int altKey);
}
 