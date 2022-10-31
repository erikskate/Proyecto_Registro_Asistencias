package com.asistenciasbackend.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Asistencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaIngreso;

    @Column(name = "ingreso_confirmado")
    private Boolean ingresoConfirmado;

    private Boolean salidaConfirmado;

    @ManyToOne
    @JoinColumn(name="estudiante_id")
    private Estudiante estudiante;

    public Asistencia() {
    }

    public Asistencia(Long id, String nombre, LocalDate fechaIngreso, Boolean ingresoConfirmado,
            Boolean salidaConfirmado, Estudiante estudiante) {
        this.id = id;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.ingresoConfirmado = ingresoConfirmado;
        this.salidaConfirmado = salidaConfirmado;
        this.estudiante = estudiante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Boolean getIngresoConfirmado() {
        return ingresoConfirmado;
    }

    public void setIngresoConfirmado(Boolean ingresoConfirmado) {
        this.ingresoConfirmado = ingresoConfirmado;
    }

    public Boolean getSalidaConfirmado() {
        return salidaConfirmado;
    }

    public void setSalidaConfirmado(Boolean salidaConfirmado) {
        this.salidaConfirmado = salidaConfirmado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    
}
