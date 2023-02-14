package com.curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.curso.modelo.entidad.Persona;

public interface PersonaDao extends JpaRepository<Persona, Integer>{

	List<Persona> findByDireccion(String direccion);
	
	List<Persona> findByDireccionOrTelefono(String direccion, String telefono);
	
	@Query("select p from Persona p where p.direccion=?1")
	List<Persona> findByMovida(String direccion);
		
}
