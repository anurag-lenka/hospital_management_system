package com.tekpyramid.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekpyramid.hms.data.entities.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer>{

}
