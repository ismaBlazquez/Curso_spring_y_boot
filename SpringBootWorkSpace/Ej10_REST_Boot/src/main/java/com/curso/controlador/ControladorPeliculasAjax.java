package com.curso.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class ControladorPeliculasAjax {

	@RequestMapping("/mostrarPeliculasAjax")
	public ModelAndView mostrarListado(){
		ModelAndView mav = new ModelAndView("peliculasAjax");
		return mav;
	}
	
}







