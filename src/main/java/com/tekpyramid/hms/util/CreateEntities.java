package com.tekpyramid.hms.util;

import java.util.Date;

import com.tekpyramid.hms.data.dto.AddressDTO;
import com.tekpyramid.hms.data.dto.BranchDTO;
import com.tekpyramid.hms.data.dto.EncounterDTO;
import com.tekpyramid.hms.data.dto.HospitalDTO;
import com.tekpyramid.hms.data.dto.ItemsDTO;
import com.tekpyramid.hms.data.dto.MedicalOrdersDTO;
import com.tekpyramid.hms.data.dto.PersonDTO;
import com.tekpyramid.hms.data.entities.Address;
import com.tekpyramid.hms.data.entities.Branch;
import com.tekpyramid.hms.data.entities.Encounter;
import com.tekpyramid.hms.data.entities.Hospital;
import com.tekpyramid.hms.data.entities.Items;
import com.tekpyramid.hms.data.entities.MedicalOrders;
import com.tekpyramid.hms.data.entities.Person;

public class CreateEntities {
	
	

	public static Hospital createHospital(HospitalDTO dto) {
		Hospital hospital = new Hospital();
		
		hospital.setHospitalName(dto.getName());
		hospital.setStartDate(new Date());
		
		return hospital;
	}
	
	public static Branch createBranch(BranchDTO branchDTO) {
		Branch branch = new Branch();
		branch.setBranchName(branchDTO.getBranchName());
		branch.setEncounters(null);
		branch.setStartDate(new Date());
		return branch;
	}
	
	public static Address createAddress(AddressDTO addressDTO) {
		Address address = new Address();
		address.setCity(addressDTO.getCity());
		address.setPinCode(addressDTO.getPinCode());
		address.setState(addressDTO.getState());
		return address;
	}
	
	public static Encounter createEncounter(EncounterDTO encounterDto) {
		
		Encounter encounter = new Encounter();
		encounter.setDoctorName(encounterDto.getDoctorName());
		encounter.setVisitDate(new Date());
		return encounter;
	}
	
	public static MedicalOrders createMedicalOrders(MedicalOrdersDTO medicalOrdersDTO) {
		MedicalOrders medicalOrders = new MedicalOrders();
		medicalOrders.setNumberOfMed(medicalOrders.getNumberOfMed());
		return medicalOrders;
	}
	
	public static Items createItems(ItemsDTO itemsDTO) {
		Items items = new Items();
		items.setDescription(itemsDTO.getDescription());
		items.setItemName(itemsDTO.getItemsName());
		items.setPrice(itemsDTO.getPrice());
		return items;
	}
	
	public static Person createPerson(PersonDTO personDTO ) {
		Person person = new Person();
		person.setAge(personDTO.getAge());
		person.setContactNumber(personDTO.getContactNumber());
		person.setName(personDTO.getName());
		return person;
	}
	
	
	
}
