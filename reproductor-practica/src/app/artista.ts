import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Artista } from '../app/dto/artista.js';

@Injectable({
  providedIn: 'root'
})
export class ArtistaService {
  private url = 'http://localhost:8080/artista'; // La URL de tu controlador

  constructor(private http: HttpClient) { }

  // Usamos el objeto Respuesta que definiste en Java
  listar(): Observable<any> {
    return this.http.get(`${this.url}/listar`);
  }

  crear(artista: Artista): Observable<any> {
    return this.http.post(`${this.url}/guardar`, artista);
  }
}