package com.tekpyramid.hms.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.BranchDAOService;
import com.tekpyramid.hms.dao.HospitalDAOService;
import com.tekpyramid.hms.data.dto.HospitalDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.HospitalService;

@Service
public class HospitalServiceImp implements HospitalService{
	
	@Autowired
	private HospitalDAOService hospitalDAOService;
	
	@Autowired
	private BranchDAOService branchDAOService;
	
	@Override
	public ResponseEntity<ResponseDTO> saveHospital(HospitalDTO hospitalDTO) {
		
		
		return hospitalDAOService.saveHospital(hospitalDTO);
		
	}

	@Override
	public ResponseEntity<ResponseDTO> updateHospital(HospitalDTO hospitalDTO) {
		
		return hospitalDAOService.updateHospital(hospitalDTO);
		
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteHospital(int altKey) {
		
		return hospitalDAOService.deleteHospital(altKey);
	}

	@Override
	public ResponseEntity<ResponseDTO> getHospital(int altKey) {
		
		return hospitalDAOService.getHospital(altKey);
		
	}

	
}
