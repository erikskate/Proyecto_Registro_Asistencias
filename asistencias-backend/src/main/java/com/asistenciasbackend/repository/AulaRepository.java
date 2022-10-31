package com.asistenciasbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asistenciasbackend.models.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long>{
    
}
