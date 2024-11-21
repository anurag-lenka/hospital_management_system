package com.tekpyramid.hms.dao;

import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.MedicalOrdersDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface MedicalOrdersDAOService {
	
	ResponseEntity<ResponseDTO> saveMedicalOrders(MedicalOrdersDTO dto);
	ResponseEntity<ResponseDTO> updateMedicalOrders(MedicalOrdersDTO dto);
	ResponseEntity<ResponseDTO> deleteMedicalOrders(int altKey);
	ResponseEntity<ResponseDTO> getMedicalOrders(int altKey);
		
}
