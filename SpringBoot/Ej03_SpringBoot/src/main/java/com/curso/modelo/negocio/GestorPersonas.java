package com.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Persona;
import com.curso.modelo.persistencia.PersonaDaoJPA;

@Service
@Transactional
public class GestorPersonas {
	
	@Autowired
	private PersonaDaoJPA personaDao;

	public void insertar(Persona persona) {
		personaDao.insertar(persona);
	}

	public List<Persona> listarTodas() {
		return personaDao.listarTodas();
	}
}
