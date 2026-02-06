package com.mx.ReproductorPractica.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.ReproductorPractica.Dominio.Artista;

@Repository
public interface ArtistaDao extends JpaRepository<Artista, Integer>{

}
