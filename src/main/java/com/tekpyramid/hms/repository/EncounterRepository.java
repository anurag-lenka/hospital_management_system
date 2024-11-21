package com.tekpyramid.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekpyramid.hms.data.entities.Encounter;

@Repository
public interface EncounterRepository extends JpaRepository<Encounter, Integer>{

}
