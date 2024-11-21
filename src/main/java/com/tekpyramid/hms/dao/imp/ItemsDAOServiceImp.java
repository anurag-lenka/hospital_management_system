package com.tekpyramid.hms.dao.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.ItemsDAOService;
import com.tekpyramid.hms.data.dto.ItemsDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.data.entities.Items;
import com.tekpyramid.hms.data.entities.MedicalOrders;
import com.tekpyramid.hms.repository.ItemsRepository;
import com.tekpyramid.hms.repository.MedicalOrdersRepository;
import com.tekpyramid.hms.util.CreateEntities;
import com.tekpyramid.hms.util.ResponseUtil;

@Service
public class ItemsDAOServiceImp implements ItemsDAOService{

	@Autowired
	private ItemsRepository itemsRepository;
	
	@Override
	public ResponseEntity<ResponseDTO> saveItems(ItemsDTO dto) {

		
		Items items = CreateEntities.createItems(dto);
		itemsRepository.save(items);
		
		return ResponseUtil.getCreateResponse("Success");
	}

	@Override
	public ResponseEntity<ResponseDTO> updateItems(ItemsDTO dto) {
		
		Optional<Items> byId = itemsRepository.findById(dto.getAltKey());
		if(byId.isEmpty()) {
			return ResponseUtil.getNotFoundResponse("Resource not found");
		}
		
		Items items = byId.get();
		items.setDescription(dto.getDescription());
		items.setItemName(dto.getItemsName());
		items.setPrice(dto.getPrice());
		itemsRepository.save(items);
		
		return ResponseUtil.getOkResponse("Updated Successfully");
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteItems(int altKey) {

		itemsRepository.deleteById(altKey);
		return ResponseUtil.getOkResponse("Deleted Successfully");
	}

	@Override
	public ResponseEntity<ResponseDTO> getItems(int altKey) {

		Optional<Items> byId = itemsRepository.findById(altKey);
		if(byId.isEmpty()) {
			return ResponseUtil.getNotFoundResponse("Resource not found");
		}
		return ResponseUtil.getCreateResponse(byId.get());
	}

	
}
