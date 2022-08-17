package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import com.david.sioca.app.facade.IPedido;
import com.david.sioca.app.model.Pedido;
import com.david.sioca.app.util.JPAUtil;
public class PedidoImp implements IPedido {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> encontrarTodosProducto() {
		List<Pedido> lista = new ArrayList<>();
		Query q = entity.createQuery("FROM Pedido");
		lista = q.getResultList();
		return lista;
	}

	@Override
	public Pedido encontrarProductoId(int id) {
		Pedido p = new Pedido();
		p = entity.find(Pedido.class, id);
		return p;
	}

	@Override
	public void crearProducto(Pedido pedido) {
		entity.getTransaction().begin();
		entity.persist(pedido);
		entity.getTransaction().commit();
	}

	@Override
	public void editarProducto(Pedido pedido) {
		entity.getTransaction().begin();
		entity.merge(pedido);
		entity.getTransaction().commit();
	}

	@Override
	public void delete(int id) {
		Pedido pedido = new Pedido();
		pedido = entity.find(Pedido.class, id);
		entity.getTransaction().begin();
		entity.remove(pedido);
		entity.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> encontrarEspecial() {
		List<Pedido> lista = new ArrayList<>();
		Query q = entity.createQuery("SELECT p FROM Pedido p WHERE p.ACTIVO=0");
		lista = q.getResultList();
		return lista;
	}

}
