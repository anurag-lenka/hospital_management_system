package com.tekpyramid.hms.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.ItemsDAOService;
import com.tekpyramid.hms.data.dto.ItemsDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.service.ItemsService;

@Service
public class ItemServiceImp implements ItemsService{

	@Autowired
	private ItemsDAOService itemsDAOService;
	
	@Override
	public ResponseEntity<ResponseDTO> saveItems(ItemsDTO itemsDTO) {
		
		return itemsDAOService.saveItems(itemsDTO);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateItems(ItemsDTO itemsDTO) {

		return itemsDAOService.updateItems(itemsDTO);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteItems(int altKey) {
		
		return itemsDAOService.deleteItems(altKey);
	}

	@Override
	public ResponseEntity<ResponseDTO> getItems(int altKey) {

		return itemsDAOService.getItems(altKey);
	}

	

}
