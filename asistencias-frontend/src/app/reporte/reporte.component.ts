import { Component, OnInit } from '@angular/core';
import { Asistencia } from '../models/asistencia';
import { Aula } from '../models/aula';
import { Estudiante } from '../models/estudiante';
import { AulaService } from '../services/aula.service';

@Component({
  selector: 'app-reporte',
  templateUrl: './reporte.component.html',
  styleUrls: ['./reporte.component.css']
})
export class ReporteComponent implements OnInit {

  asistencias:Asistencia[] = [];
  aula!: Aula;
  estudiantes: Estudiante[] = [];

  constructor(private aulaService:AulaService) { }

  ngOnInit(): void {

    this.aulaService.obtenerAulaPorId(1).subscribe(respuesta =>{
      console.log(respuesta);
      this.aula = respuesta;
      this.estudiantes = this.aula.estudiantes;
      this.buscarAsitencia();
    });

  }


  buscarAsitencia(){
    this.estudiantes.forEach((e: Estudiante) => {
      this.aulaService.buscarAsistenciaPorCodigo(e.codigo).subscribe({
        next: (asistencia: Asistencia) => {
          this.asistencias.push(asistencia);
        },
        error: err => {
          let nuevaAsitencia: Asistencia =new Asistencia();
          nuevaAsitencia.estudiante = e;
          this.asistencias.push(nuevaAsitencia);
        }
      })
    });
  }

}
