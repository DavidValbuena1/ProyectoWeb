package com.david.sioca.app.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

import java.util.Map;

import com.david.sioca.app.facadeImp.RolImp;
import com.david.sioca.app.facadeImp.TipoDocumentoImp;
import com.david.sioca.app.facadeImp.UsuarioImp;
import com.david.sioca.app.model.Rol;
import com.david.sioca.app.model.TipoDocumento;
import com.david.sioca.app.model.Usuario;


@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{

	
	private static final long serialVersionUID = 1L;

	UsuarioImp user = new UsuarioImp();

	private List<Rol> listaRoles;

	private List<TipoDocumento> listaDocumentos;

	private Usuario Usuario = new Usuario();

	private Rol Rol = new Rol();

	private TipoDocumento TipoDocumento = new TipoDocumento();
	
	private static List<Boolean> list = Arrays.asList(true, true, true, true, true,true, true, true, true, true,true);
	
	public List<Boolean> getList() {
		return list;
	}

	public UsuarioBean() {

	}

	public UsuarioBean(List<Rol> listaRoles, List<TipoDocumento> listaDocumentos, Usuario usuario, Rol rol,
			TipoDocumento tipo) {
		super();
		this.listaRoles = listaRoles;
		this.listaDocumentos = listaDocumentos;
		this.Usuario = usuario;
		this.Rol = rol;
		this.TipoDocumento = tipo;
	}

	@Override
	public String toString() {
		return "UsuarioBean [listaRoles=" + listaRoles + ", listaDocumentos=" + listaDocumentos + ", usuario=" + Usuario
				+ ", rol=" + Rol + ", tipo=" + TipoDocumento + "]";
	}

	public List<Rol> getListaRoles() {
		RolImp r = new RolImp();
		return r.listaRoles();
	}

	public void setListaRoles(List<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public List<TipoDocumento> getListaDocumentos() {
		TipoDocumentoImp t = new TipoDocumentoImp();
		return t.listaDocumentos();
	}

	public void setListaDocumentos(List<TipoDocumento> listaDocumentos) {
		this.listaDocumentos = listaDocumentos;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public Rol getRol() {
		return Rol;
	}

	public void setRol(Rol rol) {
		Rol = rol;
	}

	public TipoDocumento getTipoDocumento() {
		return TipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}

	

	public List<Usuario> encontrarTodos() {
		UsuarioImp user = new UsuarioImp();
		return user.listaUsuarios();
	}

	public String nuevo() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", Usuario);
		return "crear-usuario.xhtml?faces-redirect=true";
	}

	public String encontrar(int id, Usuario usuario) {
		Usuario = user.encontrarId(id);
		Rol.setId(usuario.getRol().getId());
		TipoDocumento.setIdTipoDocumento(usuario.getTipoDocumento().getIdTipoDocumento());
		Usuario = usuario;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", Usuario);
		return "modificar-usuarios.xhtml?faces-redirect=true";
	}

	public String editar() {
		Usuario.setRol(Rol);
		Usuario.setTipoDocumento(TipoDocumento);
		user.editarUsuario(Usuario);
		System.out.println("Editando");
		this.Usuario = new Usuario();
		this.Rol = new Rol();
		this.TipoDocumento = new TipoDocumento();
		return "usuarios.xhtml?faces-redirect=true";
	}

	public String crear() {
		Usuario.setRol(Rol);
		Usuario.setTipoDocumento(TipoDocumento);
		System.out.println("Creando usuario" + toString());
		user.crearUsuario(Usuario);
		this.Usuario = new Usuario();
		this.Rol = new Rol();
		this.TipoDocumento = new TipoDocumento();
		return "usuarios.xhtml?faces-redirect=true";
	}

	public String borrar(int id) {
		user.borrarUsuario(id);
		return "usuarios.xhtml?faces-redirect=true";
	}
	
	public void onToggle(ToggleEvent e) {
		list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	public String reiniciarTabla() {
		list = Arrays.asList(true, true, true, true, true,true, true, true, true, true,true);
		return "usuarios.xhtml?faces-redirect=true";
	}
}
