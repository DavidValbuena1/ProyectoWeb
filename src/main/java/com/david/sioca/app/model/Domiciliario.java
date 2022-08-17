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
@Table (name="domiciliario")
public class Domiciliario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	private String Nombre;
	
	private String NumIdentificacion;
	
	private String Telefono;
	
	private String Correo;
	
	@OneToMany(mappedBy="domi", cascade=CascadeType.MERGE)
	private List<Domicilio> Domicilio = new ArrayList<Domicilio>();

	
	
	public List<Domicilio> getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(List<Domicilio> domicilio) {
		Domicilio = domicilio;
	}

	public Domiciliario(int id, String nombre, String numIdentificacion, String telefono, String correo,
			List<com.david.sioca.app.model.Domicilio> domicilio) {
		super();
		Id = id;
		Nombre = nombre;
		NumIdentificacion = numIdentificacion;
		Telefono = telefono;
		Correo = correo;
		Domicilio = domicilio;
	}

	public Domiciliario() {
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

	public String getNumIdentificacion() {
		return NumIdentificacion;
	}

	public void setNumIdentificacion(String numIdentificacion) {
		NumIdentificacion = numIdentificacion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}
	
}
