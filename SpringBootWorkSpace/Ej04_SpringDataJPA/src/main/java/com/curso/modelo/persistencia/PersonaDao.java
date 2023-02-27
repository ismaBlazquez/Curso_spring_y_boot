package com.curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.modelo.entidad.Persona;

public interface PersonaDao extends JpaRepository<Persona, Integer>{

	List<Persona> findByDireccion(String direccion);
	
	List<Persona> findByDireccionOrTelefono(String direccion, String telefono);
	
	@Query("select p from Persona p where p.direccion=?1")
	List<Persona> findByMovida(String direccion);
	
	/*
    //Distinct
	List<Persona> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
	List<Persona> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);
	
	//Ignore case
	List<Persona> findByLastnameIgnoreCase(String lastname);
	List<Persona> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);
	
	//Order by
	List<Persona> findByLastnameOrderByFirstnameAsc(String lastname);
	List<Persona> findByLastnameOrderByFirstnameDesc(String lastname);	
	
	//Relaciones
	List<Persona> findByDireccion_CodigoPostal(String codigoPostal);
	*/
}
