package com.pro.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity // Obligatoria
@Table(name = "coches")
public class Coche implements Serializable {

	@Id // Obligatoria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coche")
	private int idCoche;

	private String marca;
	private String modelo;
	private int potencia;

	@Transient
	private int numPuertas;

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public Coche() {
		super();
	}

	public Coche(int idCoche, String marca, String modelo, int potencia) {
		super();
		this.idCoche = idCoche;
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
	}

	public int getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Coche [idCoche=" + idCoche + ", marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia + "]";
	}

}
