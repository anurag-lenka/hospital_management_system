package com.tekpyramid.hms.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.BranchDAOService;
import com.tekpyramid.hms.data.dto.BranchDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.BranchService;

@Service
public class BranchServiceImp implements BranchService{
	
	@Autowired
	private BranchDAOService branchDAOService;
	
	@Override
	public ResponseEntity<ResponseDTO> saveBranch(BranchDTO branchDTO) {
		
		return branchDAOService.saveBranch(branchDTO);
		
	}

	@Override
	public ResponseEntity<ResponseDTO> updateBranch(BranchDTO branchDTO) {
		
		
		return branchDAOService.updateBranch(branchDTO);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteBranch(int altKey) {

		return branchDAOService.deleteBranch(altKey);
	}

	@Override
	public ResponseEntity<ResponseDTO> getBranch(int altKey) {
		
		return branchDAOService.getBranch(altKey);
	}

}
