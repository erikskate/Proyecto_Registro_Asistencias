import { Component, OnInit } from '@angular/core';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { Asistencia } from '../models/asistencia';
import { Estudiante } from '../models/estudiante';
import { AulaService } from '../services/aula.service';

@Component({
  selector: 'app-registrar-asistencia',
  templateUrl: './registrar-asistencia.component.html',
  styleUrls: ['./registrar-asistencia.component.css']
})
export class RegistrarAsistenciaComponent implements OnInit {

  asistencia: Asistencia = new Asistencia();
  estudiante: Estudiante = new Estudiante();
  mensaje: string = '';
  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'top';

  constructor(private aulaService:AulaService, private  matSnackBar:MatSnackBar) { }

  ngOnInit(): void {
  }

  registrarAsistencia(){
    this.asistencia.estudiante = this.estudiante;
    this.aulaService.registrarAsistencia(this.asistencia).subscribe({
      next: response =>{
        this.mensaje = 'Se registro asistencia';
        this.openSnackBar();
      },
      error: err =>{
        this.mensaje = err.error;
        this.openSnackBar();
      }
    })
  }

  openSnackBar() {
    this.matSnackBar.open(this.mensaje, 'Cerrar', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      duration: 3000
    });
  }

}
