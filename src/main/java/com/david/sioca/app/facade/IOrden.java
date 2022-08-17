package com.david.sioca.app.facade;

import java.util.List;

import com.david.sioca.app.model.OrdenCompra;

public interface IOrden {
	
	public List<OrdenCompra> encontrarOrdenes();
	public OrdenCompra encontrarOrden(int id);
	public void crearOrden(OrdenCompra OrdenCompra);
	public void editarOrden(OrdenCompra OrdenCompra);
	public void borrarOrden(int id);
}
