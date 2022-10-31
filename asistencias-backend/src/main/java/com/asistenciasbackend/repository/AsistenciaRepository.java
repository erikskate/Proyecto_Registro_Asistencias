package com.asistenciasbackend.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asistenciasbackend.models.Asistencia;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long>{
    
    Optional<Asistencia> findByEstudiante_CodigoAndFechaIngreso(String codigo,LocalDate fechaIngreso);

}
