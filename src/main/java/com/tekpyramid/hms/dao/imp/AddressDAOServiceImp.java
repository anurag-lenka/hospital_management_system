package com.tekpyramid.hms.dao.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekpyramid.hms.dao.AddressDAOService;
import com.tekpyramid.hms.data.dto.AddressDTO;
import com.tekpyramid.hms.data.dto.ResponseDTO;
import com.tekpyramid.hms.data.entities.Address;
import com.tekpyramid.hms.data.entities.Branch;
import com.tekpyramid.hms.repository.AddressRepository;
import com.tekpyramid.hms.repository.BranchRepository;
import com.tekpyramid.hms.util.CreateEntities;
import com.tekpyramid.hms.util.ResponseUtil;

@Service
public class AddressDAOServiceImp implements AddressDAOService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Override
	public ResponseEntity<ResponseDTO> saveAddress(AddressDTO addressDTO) {
		
		Address address = CreateEntities.createAddress(addressDTO);
		Branch branch = branchRepository.findById(addressDTO.getBranchId()).get();
		address.addBranch(branch);
		addressRepository.save(address);
		return ResponseUtil.getCreateResponse("Success");
	}

	@Override
	public ResponseEntity<ResponseDTO> updateAddress(AddressDTO addressDTO) {
		
		Address address = addressRepository.findById(addressDTO.getAltKey()).get();
		address.setCity(addressDTO.getCity());
		address.setPinCode(addressDTO.getPinCode());
		address.setState(addressDTO.getPinCode());
		addressRepository.save(address);
		return ResponseUtil.getOkResponse(addressDTO);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteAddress(int altKey) {
		
		Optional<Address> byId = addressRepository.findById(altKey);
		if(byId.isPresent()) {
			addressRepository.delete(byId.get());
			ResponseUtil.getOkResponse("Deleted Successfully");
		}
		return ResponseUtil.getNotFoundResponse("Resource not found");
	}

	@Override
	public ResponseEntity<ResponseDTO> getAddress(int altKey) {
		
		Optional<Address> byId = addressRepository.findById(altKey);
		if(byId.isEmpty())
			return ResponseUtil.getNotFoundResponse("Resource not found");
		return ResponseUtil.getOkResponse(byId.get());
		
	}

}
