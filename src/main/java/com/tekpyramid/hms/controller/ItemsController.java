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

import com.tekpyramid.hms.data.dto.ItemsDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.ItemsService;

@RestController
public class ItemsController {

	@Autowired
	private ItemsService itemsService;
	
	@PostMapping("/saveItems")
	public ResponseEntity<ResponseDTO> saveItems(@RequestBody ItemsDTO itemsDTO){
		
		return itemsService.saveItems(itemsDTO);
	}
	
	@PutMapping("/updateItems")
	public ResponseEntity<ResponseDTO> updateItems(@RequestBody ItemsDTO itemsDTO){
		
		return itemsService.updateItems(itemsDTO);
	}
	
	@DeleteMapping("/deleteItems")
	public ResponseEntity<ResponseDTO> deleteItems(@RequestHeader int altKey){
		
		return itemsService.deleteItems(altKey);
	}
	
	@GetMapping("/getItems")
	public ResponseEntity<ResponseDTO> getItems(@RequestHeader int altKey){
		
		return itemsService.getItems(altKey);
	}
}
