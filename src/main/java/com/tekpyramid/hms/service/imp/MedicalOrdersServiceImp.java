package com.tekpyramid.hms.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.MedicalOrdersDAOService;
import com.tekpyramid.hms.data.dto.MedicalOrdersDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.MedicalOrdersService;

@Service
public class MedicalOrdersServiceImp implements MedicalOrdersService{

	@Autowired
	private MedicalOrdersDAOService medicalOrdersDAOService;
	
	@Override
	public ResponseEntity<ResponseDTO> saveMedicalOrders(MedicalOrdersDTO dto) {

		return medicalOrdersDAOService.saveMedicalOrders(dto);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateMedicalOrders(MedicalOrdersDTO dto) {

		return medicalOrdersDAOService.updateMedicalOrders(dto);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteMedicalOrders(int altKey) {

		return medicalOrdersDAOService.deleteMedicalOrders(altKey);
	}

	@Override
	public ResponseEntity<ResponseDTO> getMedicalOrders(int altKey) {

		return medicalOrdersDAOService.getMedicalOrders(altKey);
	}

	
}
