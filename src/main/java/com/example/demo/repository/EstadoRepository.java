package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
