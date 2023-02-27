package com.curso.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.modelo.delegado.PeliculaDelegado;
import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.GestorPeliculas;
import com.curso.servicio.dto.PeliculaDTO;

@Controller  
public class ControladorPeliculas {

	@Autowired
	private PeliculaDelegado peliculaDelegado;
	
	public ControladorPeliculas() {
		super();
		System.out.println("Creando ControladorPeliculas");
	}

	@RequestMapping("/mostrarListadoPeliculas")
	public ModelAndView mostrarListado(){
		ModelAndView mav = new ModelAndView("listadoPeliculas");
		mav.addObject("listaPeliculas", peliculaDelegado.listar());
		return mav;
	}
	
	@RequestMapping("/nuevaPelicula")
	public ModelAndView nuevo(){
		ModelAndView mav = new ModelAndView("formularioPeliculas");
		mav.addObject("pelicula", new PeliculaDTO());
		return mav;
	}
	
	@RequestMapping("/seleccionarPelicula")
	public ModelAndView seleccionar(@RequestParam(value="id") Integer id){		
		ModelAndView mav = new ModelAndView("formularioPeliculas");
		mav.addObject("pelicula", peliculaDelegado.buscar(id));
		return mav;
	}
	
	@RequestMapping(value="/insertarPelicula")
	public ModelAndView insertar(@ModelAttribute(value="pelicula") PeliculaDTO pelicula){
		peliculaDelegado.insertar(pelicula);
		ModelAndView mav = new ModelAndView("redirect:mostrarListadoPeliculas.htm");
		return mav;
	}

	@RequestMapping("/modificarPelicula")
	public ModelAndView modificar(@ModelAttribute("pelicula") PeliculaDTO pelicula){
		peliculaDelegado.modificar(pelicula);
		ModelAndView mav = new ModelAndView("redirect:mostrarListadoPeliculas.htm");
		return mav;
	}

	@RequestMapping("/borrarPelicula")
	public ModelAndView borrar(@ModelAttribute("pelicula") PeliculaDTO pelicula){
		peliculaDelegado.borrar(pelicula);
		ModelAndView mav = new ModelAndView("redirect:mostrarListadoPeliculas.htm");
		return mav;
	}

	public List<PeliculaDTO> getListaPeliculas(){
		System.out.println("LISTANDO LAS PELICULAS");
		return peliculaDelegado.listar();
	}
	
}







