package com.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.Persona;
import com.curso.modelo.persistencia.PersonaDao;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Autowired
	private PersonaDao personaDao;	
	
	@Override
	public void run(String... arg0) throws Exception {
		
		personaDao.save(new Persona(null, "FERNANDO", "HUESCA", "999999999"));

		List<Persona> personas = (List<Persona>) personaDao.findAll();
		for(Persona pAux: personas){
			System.out.println(pAux);
		}	
		
	}
}
