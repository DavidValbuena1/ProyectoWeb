package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.david.sioca.app.facade.IOrden;
import com.david.sioca.app.model.OrdenCompra;
import com.david.sioca.app.util.JPAUtil;

public class OrdenImp implements IOrden {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenCompra> encontrarOrdenes() {
		List<OrdenCompra> lista = new ArrayList<OrdenCompra>();
		Query q = entity.createQuery("FROM OrdenCompra");
		System.out.println("En ordenCompra");
		lista = q.getResultList();
		return lista;
	}

	@Override
	public OrdenCompra encontrarOrden(int id) {
		OrdenCompra orden = new OrdenCompra();
		orden = entity.find(OrdenCompra.class, id);
		return orden;
	}

	@Override
	public void crearOrden(OrdenCompra OrdenCompra) {
		entity.getTransaction().begin();
		entity.persist(OrdenCompra);
		entity.getTransaction().commit();
	}

	@Override
	public void editarOrden(OrdenCompra OrdenCompra) {
		entity.getTransaction().begin();
		entity.merge(OrdenCompra);
		entity.getTransaction().commit();
	}

	@Override
	public void borrarOrden(int id) {
		OrdenCompra orden = new OrdenCompra();
		orden = entity.find(OrdenCompra.class, id);
		entity.getTransaction().begin();
		entity.remove(orden);
		entity.getTransaction().commit();
	}

}
