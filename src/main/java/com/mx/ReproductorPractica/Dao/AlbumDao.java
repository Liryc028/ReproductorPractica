package com.mx.ReproductorPractica.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.ReproductorPractica.Dominio.Album;

@Repository
public interface AlbumDao extends JpaRepository<Album, Integer>{

}
