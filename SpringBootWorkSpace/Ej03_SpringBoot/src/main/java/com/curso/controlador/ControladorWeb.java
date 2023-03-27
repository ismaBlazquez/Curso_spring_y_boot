package com.curso.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.curso.modelo.delegado.DelegadoPersona;
import com.curso.modelo.entidad.Persona;

@Controller
public class ControladorWeb {

	@Autowired
	private DelegadoPersona delegadoPersona;
	
	@RequestMapping(value="/verListadoPersonas")
	@ResponseBody
	public List<Persona> verPersonas(){		
		return delegadoPersona.listarTodas();
	}
	
	@RequestMapping(value="/holaCaracola")
	public ModelAndView hola(){		
		ModelAndView mav = new ModelAndView("hola");
		return mav;
	}
	
}
