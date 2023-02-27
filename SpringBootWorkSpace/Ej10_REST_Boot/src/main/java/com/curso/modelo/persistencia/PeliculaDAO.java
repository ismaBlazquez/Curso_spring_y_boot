package com.curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.modelo.entidad.Pelicula;

public interface PeliculaDAO extends JpaRepository<Pelicula, Integer>{
}
