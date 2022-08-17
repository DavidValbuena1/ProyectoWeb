package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.david.sioca.app.facade.IDomicilio;
import com.david.sioca.app.model.Domicilio;
import com.david.sioca.app.util.JPAUtil;

public class DomicilioImp implements IDomicilio{
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Domicilio> listaDomicilios() {
		List<Domicilio> lista = new ArrayList<Domicilio>();
		Query q = entity.createQuery("FROM Domicilio");
		lista = q.getResultList();
		return lista;
	}

	@Override
	public Domicilio encontrarId(int id) {
		Domicilio d = new Domicilio();
		d = entity.find(Domicilio.class, id);
		return d;
	}

	@Override
	public void crearDomicilio(Domicilio domicilio) {
		entity.getTransaction().begin();
		entity.persist(domicilio);
		System.out.println("creado");
		entity.getTransaction().commit();		
	}

	@Override
	public void borrarDomicilio(int id) {
		Domicilio d = new Domicilio();
		d = entity.find(Domicilio.class, id);
		entity.getTransaction().begin();
		entity.remove(d);
		entity.getTransaction().commit();
	}

	@Override
	public void editarDomicilio(Domicilio domicilio) {
		entity.getTransaction().begin();
		entity.merge(domicilio);
		entity.getTransaction().commit();
	}

}
