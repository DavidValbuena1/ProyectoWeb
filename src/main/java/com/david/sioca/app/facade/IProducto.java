package com.david.sioca.app.facade;

import java.util.List;

import com.david.sioca.app.model.Producto;

public interface IProducto {
	
	public List<Producto> encontrarTodosProducto();
	public Producto encontrarProductoId(long id);
	public void crearProducto(Producto producto);
	public void editarProducto(Producto producto);
	public void delete(long id);
}
