package com.tekpyramid.hms.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.HospitalDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface HospitalService {

	ResponseEntity<ResponseDTO> saveHospital(HospitalDTO hospitalDTO);
	ResponseEntity<ResponseDTO> updateHospital(HospitalDTO hospitalDTO);
	ResponseEntity<ResponseDTO> deleteHospital(int altKey);
	ResponseEntity<ResponseDTO> getHospital(int altKey);
}
