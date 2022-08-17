package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.david.sioca.app.facade.IMetodoPago;
import com.david.sioca.app.model.MetodoPago;
import com.david.sioca.app.util.JPAUtil;

public class MetodoPagoImp implements IMetodoPago{
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MetodoPago> listaMetodos() {
		List<MetodoPago> lista = new ArrayList<>();
		Query q = entity.createQuery("FROM MetodoPago");
		lista = q.getResultList();
		return lista;
	}

}
