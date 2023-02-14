package com.curso.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.delegado.PeliculaDelegado;
import com.curso.servicio.dto.PeliculaDTO;

@RestController
public class ServicioPeliculas {

	@Autowired
	private PeliculaDelegado peliculaDelegado;	

	@RequestMapping(value="peliculas",
					method=RequestMethod.POST,
					consumes="application/json")
	public void insertar(@RequestBody PeliculaDTO peliculaDTO){
		peliculaDelegado.insertar(peliculaDTO);
	}
	
	@RequestMapping(value="peliculas",
			method=RequestMethod.PUT,
			consumes="application/json")
	public void modificar(@RequestBody PeliculaDTO peliculaDTO){	
		peliculaDelegado.modificar(peliculaDTO);
	}

	@RequestMapping(value="peliculas/{id}",
			method=RequestMethod.DELETE)
	public void borrar(@PathVariable("id") Integer idPelicula){
		PeliculaDTO peliculaDTO = new PeliculaDTO();
		peliculaDTO.setId(idPelicula);
		peliculaDelegado.borrar(peliculaDTO);
	}

	@RequestMapping(value="peliculas/{id}",
			method=RequestMethod.GET,
			produces="application/json")	
	public PeliculaDTO buscar(@PathVariable("id") Integer idPelicula){
		return peliculaDelegado.buscar(idPelicula);
	}

	@RequestMapping(value="peliculasXML/{id}",
			method=RequestMethod.GET,
			produces="application/XML")	
	public PeliculaDTO buscarXML(@PathVariable("id") Integer idPelicula){
		return buscar(idPelicula);
	}
		
	@RequestMapping(value="peliculas",
			method=RequestMethod.GET,
			produces="application/json")	
	public List<PeliculaDTO> listar(){	
		return peliculaDelegado.listar();
	}	
	
}