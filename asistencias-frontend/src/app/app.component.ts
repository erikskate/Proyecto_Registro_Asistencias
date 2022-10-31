import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'asistencias-frontend';

  rutas: any[] = [
    {
      name: 'Registrar asistencia',
      router: ['registro-asistencia']
    },
    {
      name: 'Registrar salida',
      router: ['registro-salida']
    },
    {
      name: 'Reposrte de salida',
      router: ['reporte']
    }
  ];
}
