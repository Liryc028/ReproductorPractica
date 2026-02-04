package com.mx.ReproductorPractica.Dominio;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String titulo;
	Double precio;
	@Column(name = "fecha_lanzamiento")
	Date fechaLanzamiento;

}
