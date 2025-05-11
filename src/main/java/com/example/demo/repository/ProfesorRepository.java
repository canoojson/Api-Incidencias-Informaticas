package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
	@Query("SELECT p FROM Profesores p WHERE p.Departamento.nombre= :nombreDpto")
    List<Profesor> findProfesoresByDepartamento(String nombreDpto);
	
	@Query("SELECT p FROM Profesores p WHERE p.Rol = :nombreRol")
    List<Object[]> findProfesoresByRol(String nombreParque);
}

