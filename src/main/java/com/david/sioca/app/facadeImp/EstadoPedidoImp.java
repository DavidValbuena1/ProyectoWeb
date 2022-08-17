package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.david.sioca.app.facade.IEstadoPedido;
import com.david.sioca.app.model.EstadoPedido;
import com.david.sioca.app.util.JPAUtil;

public class EstadoPedidoImp implements IEstadoPedido {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoPedido> listaEstadoPedido() {
		List<EstadoPedido> lista = new ArrayList<>();
		Query q = entity.createQuery("FROM EstadoPedido");
		lista = q.getResultList();
		return lista;
	}

}
