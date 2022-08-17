package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.david.sioca.app.facade.IDetalleVenta;
import com.david.sioca.app.model.DetalleVenta;
import com.david.sioca.app.util.JPAUtil;

public class DetalleVentaImp implements IDetalleVenta {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleVenta> listaDetalleVentas() {
		List<DetalleVenta> lista = new ArrayList<DetalleVenta>();
		Query q = entity.createQuery("FROM DetalleVenta");
		lista = q.getResultList();
		return lista;
	}

	@Override
	public DetalleVenta encontrarId(int id) {
		DetalleVenta d = new DetalleVenta();
		d = entity.find(DetalleVenta.class, id);
		return d;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleVenta> listaDetallesEspecial(int id){
		List<DetalleVenta> listas = new ArrayList<DetalleVenta>();
		String sql = ("SELECT d FROM DetalleVenta d WHERE d.IdVenta.Id = ?1");
		Query query = entity.createQuery(sql);
		query.setParameter(1, id);
		listas = query.getResultList();
		return listas;
	}
	@Override
	public void crearVenta(DetalleVenta venta) {
		entity.getTransaction().begin();
		entity.persist(venta);
		entity.getTransaction().commit();
	}

	@Override
	public void borrarDetalleVenta(int id) {
		DetalleVenta d = new DetalleVenta();
		d = entity.find(DetalleVenta.class, id);
		entity.getTransaction().begin();
		entity.remove(d);
		entity.getTransaction().commit();
		
	}

	@Override
	public void editarDetalleVenta(DetalleVenta venta) {
		entity.getTransaction().begin();
		entity.merge(venta);
		entity.getTransaction().commit();
	}

}
