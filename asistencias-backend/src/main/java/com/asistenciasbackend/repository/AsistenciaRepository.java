package com.asistenciasbackend.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asistenciasbackend.models.Asistencia;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long>{
    
    Optional<Asistencia> findByEstudiante_CodigoAndFechaIngreso(String codigo,LocalDate fechaIngreso);

}
