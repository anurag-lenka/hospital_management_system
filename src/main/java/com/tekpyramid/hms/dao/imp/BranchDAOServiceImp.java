package com.tekpyramid.hms.dao.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.BranchDAOService;
import com.tekpyramid.hms.dao.EncounterDAOService;
import com.tekpyramid.hms.data.dto.AddressDTO;
import com.tekpyramid.hms.data.dto.BranchDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.data.entities.Address;
import com.tekpyramid.hms.data.entities.Branch;
import com.tekpyramid.hms.data.entities.Encounter;
import com.tekpyramid.hms.data.entities.Hospital;
import com.tekpyramid.hms.repository.BranchRepository;
import com.tekpyramid.hms.repository.HospitalRepository;
import com.tekpyramid.hms.util.CreateEntities;
import com.tekpyramid.hms.util.ResponseUtil;

@Service
public class BranchDAOServiceImp implements BranchDAOService{

	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	
	@Override
	public ResponseEntity<ResponseDTO> saveBranch(BranchDTO dto) {
		
		Branch branch = CreateEntities.createBranch(dto);
		Hospital hospital = hospitalRepository.findById(dto.getHospitalId()).get();
		branch.addHos(hospital);
		branchRepository.save(branch);
		return ResponseUtil.getCreateResponse(branch);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateBranch(BranchDTO dto) {
		
		Branch branch = branchRepository.findById(dto.getAltKey()).get();
		branch.setBranchName(dto.getBranchName());
		branchRepository.save(branch);
		return ResponseUtil.getOkResponse(dto);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteBranch(int altKey) {
		
		Optional<Branch> byId = getById(altKey);
		if(byId.isPresent()) {
			branchRepository.delete(byId.get());
			
			ResponseUtil.getOkResponse("Deleted Successfully");
		}
		return ResponseUtil.getNotFoundResponse("Resource not found");
	}

	@Override
	public ResponseEntity<ResponseDTO> getBranch(int altKey) {

		Optional<Branch> byId = getById(altKey);
		if(byId.isEmpty())
			return ResponseUtil.getNotFoundResponse("Resource not found");
		return ResponseUtil.getOkResponse(byId.get());
	}
	
	private Optional<Branch> getById(int altKey){
		
		return branchRepository.findById(altKey);
	}

}
