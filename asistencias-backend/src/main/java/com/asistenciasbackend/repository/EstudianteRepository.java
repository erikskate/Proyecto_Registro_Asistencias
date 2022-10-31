package com.asistenciasbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asistenciasbackend.models.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
    
    Optional<Estudiante> findByCodigo(String codigo);

}
