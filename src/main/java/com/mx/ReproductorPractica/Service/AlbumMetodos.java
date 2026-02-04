package com.mx.ReproductorPractica.Service;

import com.mx.ReproductorPractica.Dto.AlbumDto;
import com.mx.ReproductorPractica.Respuesta.Respuesta;

public interface AlbumMetodos {

	Respuesta crear(AlbumDto dto);

	Respuesta buscar(Integer id);

	Respuesta editar(AlbumDto dto);

	Respuesta eliminar(AlbumDto dto);

	Respuesta listar();
}
