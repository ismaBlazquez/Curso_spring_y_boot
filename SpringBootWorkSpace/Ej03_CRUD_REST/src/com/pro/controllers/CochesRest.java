package com.pro.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.delegate.CochesDelegate;
import com.pro.modelo.Coche;

@Controller
public class CochesRest {
	
	@Autowired
	private CochesDelegate cochesDelegate;
	
	public CochesDelegate getCochesDelegate() {
		return cochesDelegate;
	}

	public void setCochesDelegate(CochesDelegate cochesDelegate) {
		this.cochesDelegate = cochesDelegate;
	}

	@RequestMapping(value="/coches", method=RequestMethod.GET)
	@ResponseBody
	public List<Coche> getAll(){
		return getCochesDelegate().listarTodos();
	}
	
	@RequestMapping(value="/crear/{marca}/{modelo}/{potencia}", method=RequestMethod.GET)
	@ResponseBody
	public void create(@PathVariable("marca") String marca, @PathVariable("modelo") String modelo, @PathVariable("potencia") int potencia){
		Coche c = new Coche(0, marca, modelo, potencia);
		getCochesDelegate().insertarCoche(c);
	}
	
	@RequestMapping(value="/borrar/{id}", method=RequestMethod.GET)
	@ResponseBody
	public void create(@PathVariable("id") int id){
		Coche c = new Coche();
		c.setIdCoche(id);
		getCochesDelegate().borrarCoche(c);;
	}
}
