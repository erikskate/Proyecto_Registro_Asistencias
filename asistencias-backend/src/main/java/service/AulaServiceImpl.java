package service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asistenciasbackend.models.Asistencia;
import com.asistenciasbackend.models.Aula;
import com.asistenciasbackend.models.Estudiante;
import com.asistenciasbackend.repository.AsistenciaRepository;
import com.asistenciasbackend.repository.AulaRepository;
import com.asistenciasbackend.repository.EstudianteRepository;

@Service
@Transactional
public class AulaServiceImpl implements AulaService{

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Optional<Aula> buscarAulaPorId(Long id) {
        return aulaRepository.findById(id);
    }

    @Override
    public Optional<Asistencia> buscarAsistenciaPorCodigo(String codigo) {
        LocalDate fechaActual = LocalDate.now();
        return asistenciaRepository.findByEstudiante_CodigoAndFechaIngreso(codigo, fechaActual);
    }

    @Override
    public Optional<Estudiante> buscarEstudiantePorCodigo(String codigo) {
        return estudianteRepository.findByCodigo(codigo);
    }

    @Override
    public void registrarAsistencia(Asistencia asistencia) {
        LocalDate fechaActual = LocalDate.now();
        asistencia.setFechaIngreso(fechaActual);
        asistencia.setIngresoConfirmado(true);
        asistencia.setSalidaConfirmado(false);
        asistenciaRepository.save(asistencia);
    }

    @Override
    public void actualizarAsistencia(Asistencia asistencia) {
        asistencia.setSalidaConfirmado(true);
        asistenciaRepository.save(asistencia);
    }
    
}
