package com.david.sioca.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="salidaproducto")
public class SalidaProducto implements Serializable {
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="id_producto")
	private String id_producto;
	
	@Column(name="cantidad")
	private int Quantity;
	
	@Column(name="fecha_salida")
	private String dateEnt;
	
	@Column(name="descripcion")
	private String Descripcion;

	public SalidaProducto(long id, String id_producto, int quantity, String dateEnt, String descripcion) {
		super();
		this.id = id;
		this.id_producto = id_producto;
		Quantity = quantity;
		this.dateEnt = dateEnt;
		Descripcion = descripcion;
	}

	public SalidaProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SalidaProducto [id=" + id + ", id_producto=" + id_producto + ", Quantity=" + Quantity + ", dateEnt="
				+ dateEnt + ", Descripcion=" + Descripcion + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getDateEnt() {
		return dateEnt;
	}

	public void setDateEnt(String dateEnt) {
		this.dateEnt = dateEnt;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
