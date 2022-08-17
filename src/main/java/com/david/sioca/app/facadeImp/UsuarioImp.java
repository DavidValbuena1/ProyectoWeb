package com.david.sioca.app.facadeImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.david.sioca.app.facade.IUsuario;
import com.david.sioca.app.model.Usuario;
import com.david.sioca.app.util.JPAUtil;

public class UsuarioImp implements IUsuario {

	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listaUsuarios() {

		List<Usuario> listaU = new ArrayList<>();
		Query sql = entity.createQuery("FROM Usuario");
		listaU = sql.getResultList();

		return listaU;
	}

	@Override
	public void crearUsuario(Usuario usuario) {
		entity.getTransaction().begin();
		entity.persist(usuario);
		entity.getTransaction().commit();

	}

	@Override
	public void editarUsuario(Usuario usuario) {
		entity.getTransaction().begin();
		entity.merge(usuario);
		entity.getTransaction().commit();
	}

	@Override
	public Usuario encontrarId(int id) {
		Usuario user = new Usuario();
		user = entity.find(Usuario.class, id);
		return user;
	}

	@Override
	public void borrarUsuario(int id) {
		Usuario user = new Usuario();
		user = entity.find(Usuario.class, id);
		entity.getTransaction().begin();
		entity.remove(user);
		entity.getTransaction().commit();
	}

	public UsuarioImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public int verificarDatos(Usuario usuario) {
		int roles=0;
		List<Usuario> lista = new ArrayList<>();
		Query q = entity.createQuery("FROM Usuario u WHERE u.Correo = '" + usuario.getCorreo()+"' AND u.contraseña = '" + usuario.getContraseña()+"'" );
		lista = q.getResultList();
		for(Usuario us: lista) {
			roles = us.getRol().getId();
		}
		lista.clear();
		return roles;
	}
		
}
