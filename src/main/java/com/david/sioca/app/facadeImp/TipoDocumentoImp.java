package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import com.david.sioca.app.facade.ITipoDocumento;
import com.david.sioca.app.model.TipoDocumento;
import com.david.sioca.app.util.JPAUtil;

public class TipoDocumentoImp implements ITipoDocumento
{
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoDocumento> listaDocumentos() {
		List<TipoDocumento> lista = new ArrayList<>();
		Query q = entity.createQuery("FROM TipoDocumento");
		lista = q.getResultList();
		return lista;
	}

}
