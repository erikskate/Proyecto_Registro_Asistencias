package com.asistenciasbackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asistenciasbackend.models.Asistencia;
import com.asistenciasbackend.models.Aula;
import com.asistenciasbackend.models.Estudiante;
import com.asistenciasbackend.service.AulaService;



@RestController
@RequestMapping("/api/aulas")
@CrossOrigin(origins = "http://localhost:4200")
public class AulaController {
    
    @Autowired
    private AulaService aulaService;

    @GetMapping("/buscar-aula/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<Aula> aulaEncontrada = aulaService.buscarAulaPorId(id);

        if(!aulaEncontrada.isPresent()){
            return new ResponseEntity<>("Nose encontro el aula: "+id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(aulaEncontrada.get(), HttpStatus.OK);
    }

    @PostMapping("/registrar-asistencia")
    public ResponseEntity<String> registrarAsistencia(@RequestBody Asistencia asistencia){
        Optional<Estudiante> estudianteEncontrado = aulaService.buscarEstudiantePorCodigo(asistencia.getEstudiante().getCodigo());

        if(!estudianteEncontrado.isPresent()){
            return new ResponseEntity<String>("No se encontro estudiante con el codigo: "+ asistencia.getEstudiante().getCodigo(), HttpStatus.NOT_FOUND);
        }

        Optional<Asistencia> asistenciaEncontrada = aulaService.buscarAsistenciaPorCodigo(asistencia.getEstudiante().getCodigo());

        if(asistenciaEncontrada.isPresent()){
            return new ResponseEntity<String>("No se puede registrar 2 veces la asistencia", HttpStatus.BAD_REQUEST);
        }

        asistencia.setEstudiante(estudianteEncontrado.get());
        aulaService.registrarAsistencia(asistencia);

        return new ResponseEntity<String>("Se registro la asistencia del estudiante: "+asistencia.getEstudiante().getNombre(),HttpStatus.OK);
    }

    @PutMapping("/registrar-salida")
    public ResponseEntity<?> actualizarAsistencia(@RequestBody Asistencia asistencia){
        Optional<Estudiante> estudianteEncontrado = aulaService.buscarEstudiantePorCodigo(asistencia.getEstudiante().getCodigo());

        if(!estudianteEncontrado.isPresent()){
            return new ResponseEntity<String>("No se encontro estudiante con el codigo: "+ asistencia.getEstudiante().getCodigo(), HttpStatus.NOT_FOUND);
        }

        Optional<Asistencia> asistenciaEncontrada = aulaService.buscarAsistenciaPorCodigo(asistencia.getEstudiante().getCodigo());

        if(!asistenciaEncontrada.isPresent()){
            return new ResponseEntity<String>("No hay asistencia registrada para el codigo: "+asistencia.getEstudiante().getCodigo(), HttpStatus.BAD_REQUEST);
        }
        aulaService.actualizarAsistencia(asistenciaEncontrada.get());

        return new ResponseEntity<String>("Se actualizo la asistencia del estudiante", HttpStatus.OK);
    }

    @GetMapping("/buscar-asistencia/{codigoEstudiante}")
    public ResponseEntity<?> buscarAsistenciaPorCodigo(@PathVariable String codigoEstudiante){
        Optional<Asistencia> asistenciaEncontrada = aulaService.buscarAsistenciaPorCodigo(codigoEstudiante);

        if(!asistenciaEncontrada.isPresent()) {
            return new ResponseEntity<String>("No se encontro asistencia con este codigo: "+codigoEstudiante, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asistenciaEncontrada.get(), HttpStatus.OK);
    }
}
