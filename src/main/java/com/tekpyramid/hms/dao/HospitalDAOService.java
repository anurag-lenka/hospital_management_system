package com.tekpyramid.hms.dao;


import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.AddressDTO;
import com.tekpyramid.hms.data.dto.BranchDTO;
import com.tekpyramid.hms.data.dto.HospitalDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface HospitalDAOService {
	
	ResponseEntity<ResponseDTO> saveHospital(HospitalDTO dto);
	ResponseEntity<ResponseDTO> updateHospital(HospitalDTO dto);
	ResponseEntity<ResponseDTO> deleteHospital(int altKey);
	ResponseEntity<ResponseDTO> getHospital(int altKey);
}
