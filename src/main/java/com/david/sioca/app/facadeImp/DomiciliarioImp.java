package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.david.sioca.app.facade.IDomiciliario;
import com.david.sioca.app.model.Domiciliario;
import com.david.sioca.app.util.JPAUtil;

public class DomiciliarioImp implements IDomiciliario {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Domiciliario> listaDomiciliario() {
		List<Domiciliario> lista = new ArrayList<>();
		Query q = entity.createQuery("FROM Domiciliario");
		lista = q.getResultList();
		return lista;
	}

}
