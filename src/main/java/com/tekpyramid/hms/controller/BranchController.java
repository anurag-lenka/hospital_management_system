package com.tekpyramid.hms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.tekpyramid.hms.data.dto.BranchDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.BranchService;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseDTO> saveBranch(@RequestBody BranchDTO branchDTO){
		
		return branchService.saveBranch(branchDTO);
	}
	
	@PutMapping("/updateBranch")
	public ResponseEntity<ResponseDTO> updateBranch(@RequestBody BranchDTO branchDTO){
		
		return branchService.updateBranch(branchDTO);
	}
	
	@DeleteMapping("/deleteBranch")
	public ResponseEntity<ResponseDTO> deleteBranch(@RequestHeader int altKey){
		
		return branchService.deleteBranch(altKey);
	}
	
	@GetMapping("/getBranch")
	public ResponseEntity<ResponseDTO> getBranch(@RequestHeader int altKey){
		
		return branchService.getBranch(altKey);
	}
}
