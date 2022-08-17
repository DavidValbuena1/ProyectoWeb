package com.david.sioca.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="metodopago")
public class MetodoPago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	private String Nombre;
	
	@OneToMany(mappedBy="metodo", cascade = CascadeType.MERGE)
	private List<Pedido> pedido;

	public MetodoPago(int id, String nombre, List<Pedido> pedido) {
		super();
		Id = id;
		Nombre = nombre;
		this.pedido = pedido;
	}



	public MetodoPago() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public List<Pedido> getPedido() {
		return pedido;
	}



	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
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
