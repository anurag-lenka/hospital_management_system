package com.tekpyramid.hms.dao.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.MedicalOrdersDAOService;
import com.tekpyramid.hms.data.dto.MedicalOrdersDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.data.entities.Encounter;
import com.tekpyramid.hms.data.entities.Items;
import com.tekpyramid.hms.data.entities.MedicalOrders;
import com.tekpyramid.hms.repository.EncounterRepository;
import com.tekpyramid.hms.repository.ItemsRepository;
import com.tekpyramid.hms.repository.MedicalOrdersRepository;
import com.tekpyramid.hms.util.CreateEntities;
import com.tekpyramid.hms.util.ResponseUtil;

@Service
public class MedicalOrdersDAOServiceImp implements MedicalOrdersDAOService{

	@Autowired
	private MedicalOrdersRepository medicalOrdersRepository;
	
	@Autowired
	private EncounterRepository encounterRepository;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	@Override
	public ResponseEntity<ResponseDTO> saveMedicalOrders(MedicalOrdersDTO dto) {
		
		Items items = itemsRepository.findById(dto.getItemId()).get();
		Encounter encounter = encounterRepository.findById(dto.getEncounterId()).get();
		MedicalOrders medicalOrders = CreateEntities.createMedicalOrders(dto);
		medicalOrders.addEncounter(encounter);
		medicalOrders.addItems(items);
		medicalOrdersRepository.save(medicalOrders);
		return ResponseUtil.getCreateResponse("Success");
	}

	@Override
	public ResponseEntity<ResponseDTO> updateMedicalOrders(MedicalOrdersDTO dto) {
		Optional<MedicalOrders> byId = medicalOrdersRepository.findById(dto.getAltKey());
		if(byId.isEmpty()) {
			return ResponseUtil.getNotFoundResponse("Resource not found");
		}
		MedicalOrders medicalOrders = byId.get();
		medicalOrders.setNumberOfMed(dto.getNumberOfMed());
		medicalOrdersRepository.save(medicalOrders);
		
		return ResponseUtil.getCreateResponse("Success");
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteMedicalOrders(int altKey) {
		
		medicalOrdersRepository.deleteById(altKey);
		return ResponseUtil.getOkResponse("Deleted Successfully");
	}

	@Override
	public ResponseEntity<ResponseDTO> getMedicalOrders(int altKey) {

		Optional<MedicalOrders> byId = medicalOrdersRepository.findById(altKey);
		if(byId.isEmpty()) {
			return ResponseUtil.getNotFoundResponse("Resource not found");
		}
		return ResponseUtil.getCreateResponse(byId.get());
	}

	

}
