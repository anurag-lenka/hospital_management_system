package com.tekpyramid.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekpyramid.hms.data.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
