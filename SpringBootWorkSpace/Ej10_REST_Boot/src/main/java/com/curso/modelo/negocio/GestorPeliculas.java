package com.curso.modelo.negocio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.persistencia.PeliculaDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class GestorPeliculas {

	@Autowired
	private PeliculaDAO peliculaDAO;

	public void setPeliculaDAO(PeliculaDAO peliculaDAO) {
		this.peliculaDAO = peliculaDAO;
	}

	public void insertar(Pelicula pelicula){
		peliculaDAO.save(pelicula);
		//peliculaDAO.insertar(pelicula);
	}
	
	//Los listamos todos sin where porque somos los mejores
	public List<Pelicula> listar(){
		return peliculaDAO.findAll();
		//return peliculaDAO.listarTodos();
	}
	
	public Pelicula buscar(Integer id){		
		return peliculaDAO.findOne(id);		
		//return peliculaDAO.buscar(id);		
	}

	public void modificar(Pelicula pelicula) {
		//WTF
		peliculaDAO.save(pelicula);
		//peliculaDAO.modificar(pelicula);
	}

	public void borrar(Pelicula pelicula) {
		peliculaDAO.delete(pelicula);
		//peliculaDAO.borrar(pelicula);
	}
	
}










