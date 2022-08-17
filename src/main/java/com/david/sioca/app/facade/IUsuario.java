package com.david.sioca.app.facade;


import java.util.List;

import com.david.sioca.app.model.Usuario;

public interface IUsuario {
	
	
	public List<Usuario> listaUsuarios();
	public void crearUsuario(Usuario usuario);
	public void editarUsuario(Usuario usuario);
	public Usuario encontrarId(int id);
	public void borrarUsuario(int id);
	public int verificarDatos(Usuario usuario);
}
