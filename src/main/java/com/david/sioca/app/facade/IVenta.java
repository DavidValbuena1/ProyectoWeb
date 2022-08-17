package com.david.sioca.app.facade;

import java.util.List;

import com.david.sioca.app.model.DetalleVenta;
import com.david.sioca.app.model.Venta;

public interface IVenta {
	public List<Venta> listaVentas();
	public Venta encontrarId(int id);
	public void crearVenta(Venta venta);
	public void borrarVenta(int id);
	public void editarVenta(Venta venta);
	public int IdVenta();
	public List<DetalleVenta> listas(int id);
}
