package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.model.IncidenciaSoftware;

@Repository
public interface IncidenciaSoftwareRepository extends JpaRepository<IncidenciaSoftware, Integer> {
	
}