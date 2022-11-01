import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Asistencia } from '../models/asistencia';

@Injectable({
  providedIn: 'root'
})
export class AulaService {

  urlBackend : string = 'http://localhost:8080/api/aulas';

  constructor(private httpClient:HttpClient) { }

  obtenerAulaPorId(id:number): Observable<any>{
    return this.httpClient.get<any>(`${this.urlBackend}/buscar-aula/${id}`);
  }

  registrarAsistencia(asistencia:Asistencia): Observable<any>{
    return this.httpClient.post<any>(`${this.urlBackend}/registrar-asistencia`,asistencia);
  }

  registrarSalida(asistencia:Asistencia):Observable<any>{
    return this.httpClient.put<any>(`${this.urlBackend}/registrar-salida`,asistencia);
  }

  buscarAsistenciaPorCodigo(codigoEstudiante:string): Observable<any>{
    return this.httpClient.get<any>(`${this.urlBackend}/buscar-asistencia/${codigoEstudiante}`);
  }
}
