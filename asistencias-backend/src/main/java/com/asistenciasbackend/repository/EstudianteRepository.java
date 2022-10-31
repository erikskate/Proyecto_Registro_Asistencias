package com.asistenciasbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asistenciasbackend.models.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
    
    Optional<Estudiante> findByCodigo(String codigo);

}
