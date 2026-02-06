// En artista.component.ts
import { Component, OnInit } from '@angular/core';
import { ArtistaService } from '../artista.js';
import { Artista } from '../dto/artista.js';

@Component({
  selector: 'app-artista',
  templateUrl: './artista.component.html'
})
export class ArtistaComponent implements OnInit {
  artistas: Artista[] = [];

  constructor(private artistaService: ArtistaService) { }

  ngOnInit(): void {
    this.obtenerArtistas();
  }

  obtenerArtistas() {
    this.artistaService.listar().subscribe(data => {
      if (data.success) {
        // 'obj' contiene la lista de DTOs que envía Spring Boot
        this.artistas = data.obj;
      }
    });
  }
}