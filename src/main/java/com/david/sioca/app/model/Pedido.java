package com.david.sioca.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id_pedido;
	
	@Column(name="Nombres_usuario")
	private String Nombres;
	
	@Column(name="FechaHora", nullable = false,updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name="Cantidad")
	private int Cantidad;
	
	@Column(name="Referencias")
	private String Referencia;
	
	@Column(name="Direccion")
	private String Direccion;
	
	@Column(name="Inf_adicional", nullable = true)
	private String Informacion;
	
	@Column(name="Nombres_vendedor")
	private String Vendedor;
	
	@Column (name="Valor")
	private long Precio;
	
	@ManyToOne
	@JoinColumn(name="Metodo_pago")
	private MetodoPago metodo;
	
	@ManyToOne
	@JoinColumn(name="EstadoPedido")
	private EstadoPedido estado;
	
	@ManyToOne
	@JoinColumn(name="EstadoPago")
	private EstadoPago pago;
	

	
	private int ACTIVO;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Pedido(int id_pedido, String nombres, Date date, int cantidad, String referencia, String direccion,
			String informacion, String vendedor, long precio, MetodoPago metodo, EstadoPedido estado, EstadoPago pago, int aCTIVO) {
		super();
		Id_pedido = id_pedido;
		Nombres = nombres;
		this.date = date;
		Cantidad = cantidad;
		Referencia = referencia;
		Direccion = direccion;
		Informacion = informacion;
		Vendedor = vendedor;
		Precio = precio;
		this.metodo = metodo;
		this.estado = estado;
		this.pago = pago;
		ACTIVO = aCTIVO;
	}



	


	public int getACTIVO() {
		return ACTIVO;
	}



	public void setACTIVO(int aCTIVO) {
		ACTIVO = aCTIVO;
	}


	public int getId_pedido() {
		return Id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		Id_pedido = id_pedido;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public String getReferencia() {
		return Referencia;
	}

	public void setReferencia(String referencia) {
		Referencia = referencia;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getInformacion() {
		return Informacion;
	}

	public void setInformacion(String informacion) {
		Informacion = informacion;
	}

	public String getVendedor() {
		return Vendedor;
	}

	public void setVendedor(String vendedor) {
		Vendedor = vendedor;
	}

	public long getPrecio() {
		return Precio;
	}

	public void setPrecio(long precio) {
		Precio = precio;
	}

	public MetodoPago getMetodo() {
		return metodo;
	}

	public void setMetodo(MetodoPago metodo) {
		this.metodo = metodo;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public EstadoPago getPago() {
		return pago;
	}

	public void setPago(EstadoPago pago) {
		this.pago = pago;
	}

	
	
	
}
