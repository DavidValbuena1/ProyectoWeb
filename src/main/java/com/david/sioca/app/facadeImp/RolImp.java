package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.david.sioca.app.facade.IRol;
import com.david.sioca.app.model.Rol;
import com.david.sioca.app.util.JPAUtil;

public class RolImp implements IRol {
	
EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> listaRoles() {
		List<Rol> lista = new ArrayList<>();
		Query q = entity.createQuery("FROM Rol");
		lista = q.getResultList();
		return lista;
	}
	
	public Rol encontrarId(int id) {
		Rol r = new Rol();
		r = entity.find(Rol.class, id);
		return r;
	}
}
