package com.tekpyramid.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekpyramid.hms.data.entities.MedicalOrders;

@Repository
public interface MedicalOrdersRepository extends JpaRepository<MedicalOrders, Integer>{

}
