import { Component, OnInit } from '@angular/core';
import { Asistencia } from '../models/asistencia';

@Component({
  selector: 'app-reporte',
  templateUrl: './reporte.component.html',
  styleUrls: ['./reporte.component.css']
})
export class ReporteComponent implements OnInit {

  asistencia:Asistencia[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
