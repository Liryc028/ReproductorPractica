package com.mx.ReproductorPractica.Dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistaDto {

	private Integer id;
	private String nombre;
	private String genero;
	private Date fechaDebut;

	private List<AlbumDto> albums; // Añade esta lista

}
