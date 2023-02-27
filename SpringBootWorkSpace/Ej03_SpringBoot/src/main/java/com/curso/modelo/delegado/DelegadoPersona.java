package com.curso.modelo.delegado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Persona;
import com.curso.modelo.negocio.GestorPersonas;

@Component
public class DelegadoPersona {
	
	@Autowired
	private GestorPersonas gestorPersonas;

	public void insertar(Persona persona){
		gestorPersonas.insertar(persona);
	}
	
	public List<Persona> listarTodas(){
		return gestorPersonas.listarTodas();
	}
}
