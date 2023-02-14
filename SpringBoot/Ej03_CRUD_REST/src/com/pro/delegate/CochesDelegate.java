package com.pro.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pro.manager.CochesManager;
import com.pro.modelo.Coche;


@Component
public class CochesDelegate {

	@Autowired
	private CochesManager cochesManager;
	
	
	public CochesManager getCochesManager() {
		return cochesManager;
	}

	public void setCochesManager(CochesManager cochesManager) {
		this.cochesManager = cochesManager;
	}

	public void insertarCoche(Coche coche){
		cochesManager.insertarCoche(coche);;		
	}
	
	public void modificarCoche(Coche coche) {
		cochesManager.modificarCoche(coche);;		
	}

	public void borrarCoche(Coche coche) {
		cochesManager.borrarCoche(coche);;		
	}	
	
	public Coche buscarCoche(int idCoche) {
		return cochesManager.buscarCoche(idCoche);
	}

	public List<Coche> listarTodos(){
		return cochesManager.listarTodos();
	}
	
}
