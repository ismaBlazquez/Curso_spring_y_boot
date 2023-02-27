package com.curso.modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Persona;

@Repository
public class PersonaDaoJPA {

	@PersistenceContext
	private EntityManager em;
	
	public void insertar(Persona persona){
		em.persist(persona);
	}
	
	public List<Persona> listarTodas(){
		List<Persona> personas = em.createQuery("Select t from Persona t").getResultList();;
		return personas;
	}
	
}





