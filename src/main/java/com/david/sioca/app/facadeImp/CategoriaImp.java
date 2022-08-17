package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import com.david.sioca.app.facade.ICategoria;
import com.david.sioca.app.model.Categoria;
import com.david.sioca.app.util.JPAUtil;

public class CategoriaImp implements ICategoria {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listacategoria() {
		List<Categoria> lista = new ArrayList<>();
		Query q = entity.createQuery("FROM Categoria");
		lista = q.getResultList();
		return lista;
	}
	
}
