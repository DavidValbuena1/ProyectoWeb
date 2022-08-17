package com.david.sioca.app.facade;

import java.util.List;

import com.david.sioca.app.model.Pedido;

public interface IPedido {
	public List<Pedido> encontrarTodosProducto();
	public List<Pedido> encontrarEspecial();
	public Pedido encontrarProductoId(int id);
	public void crearProducto(Pedido pedido);
	public void editarProducto(Pedido pedido);
	public void delete(int id);

}
