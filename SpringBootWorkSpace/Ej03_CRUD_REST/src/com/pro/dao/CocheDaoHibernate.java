package com.pro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pro.modelo.Coche;

@Repository
public class CocheDaoHibernate {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void insertar(Coche coche) {
		hibernateTemplate.save(coche);
	}

	public void modificar(Coche coche) {
		System.out.println("DAO:" + coche);
		hibernateTemplate.update(coche);
	}

	public void borrar(Coche coche) {
		hibernateTemplate.delete(coche);
	}

	public Coche buscar(int idCoche) {
		return (Coche) hibernateTemplate.get(Coche.class, idCoche);
	}

	public List<Coche> listarTodos() {
		return hibernateTemplate.find("select c from Coche c");
	}

}
