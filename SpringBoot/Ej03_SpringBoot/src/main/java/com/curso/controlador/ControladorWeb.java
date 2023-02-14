package com.curso.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.curso.modelo.delegado.DelegadoPersona;

@Controller
public class ControladorWeb {

	@Autowired
	private DelegadoPersona delegadoPersona;
	
	@RequestMapping(value="/verListadoPersonas")
	public ModelAndView verPersonas(){		
		ModelAndView mav = new ModelAndView("listadoPersonas");
		mav.addObject("listaPersonas", delegadoPersona.listarTodas());
		return mav;
	}
	
	@RequestMapping(value="/holaCaracola")
	public ModelAndView hola(){		
		ModelAndView mav = new ModelAndView("hola");
		return mav;
	}
	
}
