package com.david.sioca.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="domicilio")
public class Domicilio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdDomicilio;
	
	@Column(name="NumGuia")
	private String NumGuia;
	
	@Column(name="ValorDomicilio")
	private long ValorDomicilio;
	
	@Column(name="FechaSalida")
	@Temporal(TemporalType.DATE)
	private Date FechaSalida;
	
	@Column(name="FechaEntrega")
	@Temporal(TemporalType.DATE)
	private Date FechaEntrega;
	
	@ManyToOne
	@JoinColumn(name="Estado")
	private EstadoDomicilio estado;
	
	@OneToOne
	@JoinColumn(name="pedidos_Id_pedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="IdDomiciliario")
	private Domiciliario domi;
	
	@Column(name="InformacionAdicional")
	private String InformacionAdicional;

	public Domicilio() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Domicilio [IdDomicilio=" + IdDomicilio + ", NumGuia=" + NumGuia + ", ValorDomicilio=" + ValorDomicilio
				+ ", FechaSalida=" + FechaSalida + ", FechaEntrega=" + FechaEntrega + ", estado=" + estado + ", pedido="
				+ pedido + ", domi=" + domi + ", InformacionAdicional=" + InformacionAdicional + "]";
	}

	public EstadoDomicilio getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoDomicilio estado) {
		this.estado = estado;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Domiciliario getDomi() {
		return domi;
	}

	public void setDomi(Domiciliario domi) {
		this.domi = domi;
	}

	public Domicilio(int idDomicilio, String numGuia, long valorDomicilio, Date fechaSalida, Date fechaEntrega,
			EstadoDomicilio estado, Pedido pedido, Domiciliario domi, String informacionAdicional) {
		super();
		IdDomicilio = idDomicilio;
		NumGuia = numGuia;
		ValorDomicilio = valorDomicilio;
		FechaSalida = fechaSalida;
		FechaEntrega = fechaEntrega;
		this.estado = estado;
		this.pedido = pedido;
		this.domi = domi;
		InformacionAdicional = informacionAdicional;
	}

	public int getIdDomicilio() {
		return IdDomicilio;
	}

	public void setIdDomicilio(int idDomicilio) {
		IdDomicilio = idDomicilio;
	}

	public String getNumGuia() {
		return NumGuia;
	}

	public void setNumGuia(String numGuia) {
		NumGuia = numGuia;
	}

	public long getValorDomicilio() {
		return ValorDomicilio;
	}

	public void setValorDomicilio(long valorDomicilio) {
		ValorDomicilio = valorDomicilio;
	}

	public Date getFechaSalida() {
		return FechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		FechaSalida = fechaSalida;
	}

	public Date getFechaEntrega() {
		return FechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		FechaEntrega = fechaEntrega;
	}

	public String getInformacionAdicional() {
		return InformacionAdicional;
	}

	public void setInformacionAdicional(String informacionAdicional) {
		InformacionAdicional = informacionAdicional;
	}
	
	
	
}
