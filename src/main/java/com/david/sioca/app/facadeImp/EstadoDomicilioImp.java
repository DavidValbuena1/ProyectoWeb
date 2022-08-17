package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.david.sioca.app.facade.IEstadoDomicilio;
import com.david.sioca.app.model.EstadoDomicilio;
import com.david.sioca.app.util.JPAUtil;

public class EstadoDomicilioImp implements IEstadoDomicilio {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoDomicilio> listaEstadoDomicilio() {
		List<EstadoDomicilio> lista = new ArrayList<EstadoDomicilio>();
		Query q = entity.createQuery("FROM EstadoDomicilio");
		lista = q.getResultList();
		return lista;
	}

}
