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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Artistas")
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String nombre;
	String genero;
	@Column(name = "fecha_debut")
	Date fechaDebut;

}
