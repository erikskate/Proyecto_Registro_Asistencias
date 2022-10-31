package com.asistenciasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asistenciasbackend.models.Aula;

public interface AulaRepository extends JpaRepository<Aula, Long>{
    
}
