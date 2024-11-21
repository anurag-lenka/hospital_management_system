package com.tekpyramid.hms.dao;

import org.springframework.http.ResponseEntity;

import com.tekpyramid.hms.data.dto.ItemsDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;

public interface ItemsDAOService {

	ResponseEntity<ResponseDTO> saveItems(ItemsDTO dto);
	ResponseEntity<ResponseDTO> updateItems(ItemsDTO dto);
	ResponseEntity<ResponseDTO> deleteItems(int altKey);
	ResponseEntity<ResponseDTO> getItems(int altKey);
}
