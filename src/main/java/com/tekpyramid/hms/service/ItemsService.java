package com.tekpyramid.hms.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.ItemsDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface ItemsService {

	ResponseEntity<ResponseDTO> saveItems(ItemsDTO itemsDTO);
	ResponseEntity<ResponseDTO> updateItems(ItemsDTO itemsDTO);
	ResponseEntity<ResponseDTO> deleteItems(int altKey);
	ResponseEntity<ResponseDTO> getItems(int altKey);
}
