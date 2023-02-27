package com.pro.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pro.dao.CocheDaoHibernate;
import com.pro.modelo.Coche;


@Service
@Transactional
public class CochesManager {

	@Autowired
	private CocheDaoHibernate cocheDao;
	
	public void setCocheDao(CocheDaoHibernate cocheDao) {
		this.cocheDao = cocheDao;
	}

	public void insertarCoche(Coche coche){
		cocheDao.insertar(coche);		
	}
	
	public void modificarCoche(Coche coche) {
		cocheDao.modificar(coche);		
	}

	public void borrarCoche(Coche coche) {
		cocheDao.borrar(coche);		
	}	
	
	public Coche buscarCoche(int idCoche) {
		return cocheDao.buscar(idCoche);
	}

	public List<Coche> listarTodos(){
		return cocheDao.listarTodos();
	}
	
}
