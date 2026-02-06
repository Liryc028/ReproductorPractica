package com.mx.ReproductorPractica.Dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlbumDto {

	private Integer id;
	private String titulo;
	private Double precio;
	private Date fechaLanzamiento;
}
