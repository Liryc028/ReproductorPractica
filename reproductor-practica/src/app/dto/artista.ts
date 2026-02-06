// En src/app/modelos/artista.ts (o donde hayas creado la interfaz)
export interface Album {
  id?: number;
  titulo: string;
  precio: number;
  fechaLanzamiento: string;
}

export interface Artista {
  id?: number;
  nombre: string;
  genero: string;
  fechaDebut: string;
  albums: Album[]; // Aquí está la lista que mapeamos en Java
}