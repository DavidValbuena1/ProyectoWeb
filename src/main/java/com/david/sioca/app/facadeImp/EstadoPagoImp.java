package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.david.sioca.app.facade.IEstadoPago;
import com.david.sioca.app.model.EstadoPago;
import com.david.sioca.app.util.JPAUtil;

public class EstadoPagoImp implements IEstadoPago {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoPago> listaEstadoPago() {
		List<EstadoPago> lista = new ArrayList<>();
		Query q = entity.createQuery("FROM EstadoPago");
		lista = q.getResultList();
		return lista;
	}

}
