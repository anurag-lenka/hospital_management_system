package com.tekpyramid.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekpyramid.hms.data.entities.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>{

}
