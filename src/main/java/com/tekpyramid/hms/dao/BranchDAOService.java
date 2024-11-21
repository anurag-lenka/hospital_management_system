package com.tekpyramid.hms.dao;

import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.BranchDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface BranchDAOService {
	
	ResponseEntity<ResponseDTO> saveBranch(BranchDTO dto);
	ResponseEntity<ResponseDTO> updateBranch(BranchDTO dto);
	ResponseEntity<ResponseDTO> deleteBranch(int altKey);
	ResponseEntity<ResponseDTO> getBranch(int altKey);
}
