package com.david.sioca.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="estadodomicilio")
public class EstadoDomicilio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	private String Nombre;
	
	@OneToMany(mappedBy="estado", cascade=CascadeType.MERGE)
	private List<Domicilio> Domicilio = new ArrayList<Domicilio>();

	

	public EstadoDomicilio(int id, String nombre, List<com.david.sioca.app.model.Domicilio> domicilio) {
		super();
		Id = id;
		Nombre = nombre;
		Domicilio = domicilio;
	}

	public List<Domicilio> getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(List<Domicilio> domicilio) {
		Domicilio = domicilio;
	}

	public EstadoDomicilio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
}
