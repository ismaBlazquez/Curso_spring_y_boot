package com.curso.modelo.delegado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.GestorPeliculas;
import com.curso.servicio.dto.PeliculaDTO;

@Component
public class PeliculaDelegado {

	@Autowired
	private GestorPeliculas gestorPeliculas;

	public GestorPeliculas getGestorPeliculas() {
		return gestorPeliculas;
	}

	public void setGestorPeliculas(GestorPeliculas gestorPeliculas) {
		this.gestorPeliculas = gestorPeliculas;
	}

	public void insertar(PeliculaDTO peliculaDto){
		gestorPeliculas.insertar(peliculaDto.asPelicula());
	}
	
	public List<PeliculaDTO> listar(){
		List<Pelicula> listaPeliculas = gestorPeliculas.listar();
		List<PeliculaDTO> listaPeliculasDto = new ArrayList<PeliculaDTO>();
		for (Iterator<Pelicula> iterator = listaPeliculas.iterator(); iterator.hasNext();) {
			Pelicula pelicula = (Pelicula) iterator.next();
			listaPeliculasDto.add(new PeliculaDTO(pelicula));
		}
		return listaPeliculasDto;
	}
	
	public PeliculaDTO buscar(Integer id){		
		return new PeliculaDTO(gestorPeliculas.buscar(id));		
	}

	public void modificar(PeliculaDTO pelicula) {
		gestorPeliculas.modificar(pelicula.asPelicula());
	}

	public void borrar(PeliculaDTO pelicula) {
		gestorPeliculas.borrar(pelicula.asPelicula());
	}
}
