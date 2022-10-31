package com.asistenciasbackend.service;

import java.util.Optional;

import com.asistenciasbackend.models.Asistencia;
import com.asistenciasbackend.models.Aula;
import com.asistenciasbackend.models.Estudiante;

public interface AulaService {
    
    public Optional<Aula> buscarAulaPorId(Long id);
    public Optional<Asistencia> buscarAsistenciaPorCodigo(String codigo);
    public Optional<Estudiante> buscarEstudiantePorCodigo(String codigo);
    public void registrarAsistencia(Asistencia asistencia);
    public void actualizarAsistencia(Asistencia asistencia);
}
