package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Parque;

public interface ParqueRepository extends JpaRepository<Parque, Integer> {
	@Query("SELECT p FROM Parque p WHERE p.comunidadAutonoma.nombre= :comunidadnombre")
    List<Parque> findParquesByComunidadAutonoma(String comunidadnombre);
	
	@Query("SELECT e.nombre, e.tipo FROM Parque p JOIN p.especies e WHERE p.nombre = :nombreParque")
    List<Object[]> findEspeciesByNombreParque(String nombreParque);
    
    @Query("SELECT p.nombre, e FROM Parque p JOIN p.especies e")
    List<Object[]> findAllParquesWithEspecies();
    
}

