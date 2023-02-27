package com.curso;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.curso.modelo.delegado.DelegadoPersona;
import com.curso.modelo.entidad.Persona;
import com.curso.modelo.persistencia.PersonaDaoJPA;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Aplicacion.class, args);

		//System.out.println("====================================");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		
		//PersonaDaoJPA personaDao = ctx.getBean(PersonaDaoJPA.class);
		//personaDao.insertar(persona);

	}

	@Autowired
	private DelegadoPersona delegadoPersona;

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("====================================");
		System.out.println("App inicializada");
		
		delegadoPersona.insertar(new Persona(null,"N1","D","T"));
		delegadoPersona.insertar(new Persona(null,"N2","D","T"));
		delegadoPersona.insertar(new Persona(null,"N3","D","T"));
		delegadoPersona.insertar(new Persona(null,"N4","D","T"));
		delegadoPersona.insertar(new Persona(null,"N5","D","T"));
		

		List<Persona> personas = delegadoPersona.listarTodas();
		for(Persona p: personas){
			System.out.println(p);
		}
	
	
	}
}
