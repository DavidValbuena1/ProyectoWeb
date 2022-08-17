package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import com.david.sioca.app.facade.IProducto;
import com.david.sioca.app.model.Producto;
import com.david.sioca.app.util.JPAUtil;

public class ProductoImp implements IProducto {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> encontrarTodosProducto() {
		List<Producto> listaProducto = new ArrayList<>();
		Query sql = entity.createQuery("FROM Producto");
		listaProducto = sql.getResultList();
		return listaProducto;
	}

	@Override
	public Producto encontrarProductoId(long id) {
		Producto producto = new Producto();
		System.out.println("id " + id);
		if(id!=0) {
			producto = entity.find(Producto.class, id);
			return producto;
		}
		return null;
	}

	@Override
	public void crearProducto(Producto producto) {
		entity.getTransaction().begin();
		entity.persist(producto);
		entity.getTransaction().commit();

	}

	@Override
	public void editarProducto(Producto producto) {
		entity.getTransaction().begin();
		entity.merge(producto);
		entity.getTransaction().commit();
	}

	@Override
	public void delete(long id) {
		Producto producto = new Producto();
		try {
			producto = entity.find(Producto.class, id);
			entity.getTransaction().begin();
			entity.remove(producto);
			entity.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMessageError(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
