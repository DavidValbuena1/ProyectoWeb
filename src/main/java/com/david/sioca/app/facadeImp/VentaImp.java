package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.david.sioca.app.facade.IVenta;
import com.david.sioca.app.model.DetalleVenta;
import com.david.sioca.app.model.Venta;
import com.david.sioca.app.util.JPAUtil;

public class VentaImp implements IVenta {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> listaVentas() {
		List<Venta> lista= new ArrayList<Venta>();
		Query q = entity.createQuery("FROM Venta");
		lista=q.getResultList();
		return lista;
	}

	@Override
	public Venta encontrarId(int id) {
		Venta v = new Venta();
		v=entity.find(Venta.class, id);
		return v;
	}

	@Override
	public void crearVenta(Venta venta) {
		entity.getTransaction().begin();
		entity.persist(venta);
		entity.getTransaction().commit();		
	}

	@Override
	public void borrarVenta(int id) {
		Venta v = new Venta();
		v = entity.find(Venta.class, id);
		System.out.println("Hola");
		entity.getTransaction().begin();
		entity.remove(v);
		entity.getTransaction().commit();		
	}

	@Override
	public void editarVenta(Venta venta) {
		entity.getTransaction().begin();
		entity.merge(venta);
		System.out.println("Editaste la venta desde la imp " + venta);
		entity.getTransaction().commit();		
	}

	@Override
	public int IdVenta() {
		int Id;
		Query q = entity.createQuery("SELECT MAX(v.Id) FROM Venta v");
		Id = (Integer) q.getSingleResult();
		System.out.println("Hola estas en idventa" + Id);
		return Id;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleVenta> listas(int id){
		Query q = entity.createQuery("SELECT d FROM DetalleVenta d WHERE d.IdVenta = "+id);
		return q.getResultList();
	}

}
