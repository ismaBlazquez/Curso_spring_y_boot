import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.cfg.Configuracion;
import com.curso.modelo.entidad.Persona;
import com.curso.modelo.persistencia.PersonaDao;

public class PruebasSpring {

	public static void main(String[] args){
		
		AnnotationConfigApplicationContext appCtx = 
			new AnnotationConfigApplicationContext(Configuracion.class);
		
		PersonaDao personaDao = (PersonaDao) appCtx.getBean("personaDao");
		
		/*
		personaDao.save(new Persona(null,"Groucho Marx","C/Tal","555123"));
		*/
		
		Persona p = new Persona(195, "Groucho Marx", "C/Tal", "555123");
		personaDao.save(p);
		

		List<Persona> personas = personaDao.findAll();
		for(Persona pAux: personas){
			System.out.println(pAux);
		}
		
		
		
		
	}
	
}
