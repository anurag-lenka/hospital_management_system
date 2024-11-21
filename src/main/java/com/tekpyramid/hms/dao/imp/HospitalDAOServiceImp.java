package com.tekpyramid.hms.dao.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.BranchDAOService;
import com.tekpyramid.hms.dao.HospitalDAOService;
import com.tekpyramid.hms.data.dto.AddressDTO;
import com.tekpyramid.hms.data.dto.BranchDTO;
import com.tekpyramid.hms.data.dto.HospitalDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.data.entities.Branch;
import com.tekpyramid.hms.data.entities.Hospital;
import com.tekpyramid.hms.repository.HospitalRepository;
import com.tekpyramid.hms.util.CreateEntities;
import com.tekpyramid.hms.util.ResponseUtil;

@Service
public class HospitalDAOServiceImp implements HospitalDAOService{
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Override
	public ResponseEntity<ResponseDTO> saveHospital(HospitalDTO dto) {

		Hospital hospital = CreateEntities.createHospital(dto);
		hospitalRepository.save(hospital);
		return ResponseUtil.getCreateResponse("Success");
	}

	@Override
	public ResponseEntity<ResponseDTO> updateHospital(HospitalDTO dto) {
		
		Optional<Hospital> byId = hospitalRepository.findById(dto.getAltKey());
		if(byId.isPresent()) {
			Hospital hospital = byId.get();
			hospital.setHospitalName(dto.getName());
			hospitalRepository.save(hospital);
			return ResponseUtil.getOkResponse("Updated Successfully");
		}
		
		return ResponseUtil.getNotFoundResponse("Resource not found");
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteHospital(int altKey) {
		
		hospitalRepository.deleteById(altKey);
		return ResponseUtil.getOkResponse("Deleted Successfully");
	}

	@Override
	public ResponseEntity<ResponseDTO> getHospital(int altKey) {
		
		Optional<Hospital> byId = hospitalRepository.findById(altKey);
		if(byId.isEmpty())
			return ResponseUtil.getNotFoundResponse("Resource not found");
		return ResponseUtil.getCreateResponse(byId.get());
	}

}
