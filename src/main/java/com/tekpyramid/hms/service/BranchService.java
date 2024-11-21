package com.tekpyramid.hms.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.BranchDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface BranchService {

	ResponseEntity<ResponseDTO> saveBranch(BranchDTO branchDTO);
	ResponseEntity<ResponseDTO> updateBranch(BranchDTO branchDTO);
	ResponseEntity<ResponseDTO> deleteBranch(int altKey);
	ResponseEntity<ResponseDTO> getBranch(int altKey);
}
