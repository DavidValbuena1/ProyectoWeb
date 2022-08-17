package com.david.sioca.app.facade;

import java.util.List;

import com.david.sioca.app.model.DetalleVenta;

public interface IDetalleVenta {
	public List<DetalleVenta> listaDetalleVentas();
	public DetalleVenta encontrarId(int id);
	public void crearVenta(DetalleVenta venta);
	public void borrarDetalleVenta(int id);
	public void editarDetalleVenta(DetalleVenta venta);
	public List<DetalleVenta> listaDetallesEspecial(int id);
}
