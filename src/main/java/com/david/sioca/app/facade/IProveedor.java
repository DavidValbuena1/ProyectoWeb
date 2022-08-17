package com.david.sioca.app.facade;

import java.util.List;

import com.david.sioca.app.model.Proveedor;

public interface IProveedor {
	
	public List<Proveedor> encontrar();
	public Proveedor encontrarPorId(int id);
	public void crearProveedor(Proveedor proveedor);
	public void editarProveedor(Proveedor proveedor);
	public void delete(int id);
}
