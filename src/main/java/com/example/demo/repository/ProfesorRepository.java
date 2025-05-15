package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
	@Query("SELECT p FROM Profesor p WHERE p.departamento.nombreDpto= :nombreDpto")
    List<Profesor> findProfesoresByDepartamento(@Param("nombreDpto")String nombreDpto);
	
	@Query("SELECT p FROM Profesor p WHERE p.rol = :nombreRol")
    List<Object[]> findProfesoresByRol(@Param("nombreRol")String nombreRol);
}

