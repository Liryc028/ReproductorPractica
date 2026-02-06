package com.mx.ReproductorPractica.Service;

import com.mx.ReproductorPractica.Dto.ArtistaDto;
import com.mx.ReproductorPractica.Respuesta.Respuesta;

public interface ArtistaMetodos {

	Respuesta crear(ArtistaDto dto);

	Respuesta Editar(ArtistaDto dto);

	Respuesta buscar(Integer id);

	Respuesta elimiar(Integer id);

	Respuesta listar();

}
