package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import com.david.sioca.app.facade.IProveedor;
import com.david.sioca.app.model.Proveedor;
import com.david.sioca.app.util.JPAUtil;

public class ProveedorImp implements IProveedor {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> encontrar() {
		List<Proveedor> listaProveedor = new ArrayList<>();
		Query s =  entity.createQuery("FROM Proveedor");
		listaProveedor = s.getResultList();		
		return listaProveedor;
	}
	@Override
	public void crearProveedor(Proveedor proveedor) {
		entity.getTransaction().begin();
		entity.persist(proveedor);
		entity.getTransaction().commit();
	}
	@Override
	public void editarProveedor(Proveedor proveedor) {
		entity.getTransaction().begin();
		entity.merge(proveedor);
		entity.getTransaction().commit();
	}
	@Override
	public Proveedor encontrarPorId(int id) {
		Proveedor proveedor = new Proveedor();
		proveedor = entity.find(Proveedor.class, id);
		return proveedor;
	}
	
	@Override
	public void delete(int id) {
		Proveedor proveedor = new Proveedor();
		proveedor = entity.find(Proveedor.class, id);
		entity.getTransaction().begin();
		entity.remove(proveedor);
		entity.getTransaction().commit();
		
	}
	
	
	
}
