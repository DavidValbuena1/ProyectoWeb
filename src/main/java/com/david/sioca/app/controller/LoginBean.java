package com.david.sioca.app.controller;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.david.sioca.app.facadeImp.RolImp;
import com.david.sioca.app.facadeImp.TipoDocumentoImp;
import com.david.sioca.app.facadeImp.UsuarioImp;
import com.david.sioca.app.model.Rol;
import com.david.sioca.app.model.TipoDocumento;
import com.david.sioca.app.model.Usuario;
import com.david.sioca.app.util.SessionUtils;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
	UsuarioImp u = new UsuarioImp();
	
	private List<Usuario> listaCorreos;

	private List<Rol> listaRoles;

	private List<TipoDocumento> listaDocumentos;

	private Usuario usuario = new Usuario();

	private Rol Rol = new Rol();

	private TipoDocumento TipoDocumento = new TipoDocumento();

	

	

	@Override
	public String toString() {
		return "LoginBean [u=" + u + ", listaCorreos=" + listaCorreos + ", listaRoles=" + listaRoles
				+ ", listaDocumentos=" + listaDocumentos + ", usuario=" + usuario + ", Rol=" + Rol + ", TipoDocumento="
				+ TipoDocumento + "]";
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
	
	
	public List<Usuario> getListaCorreos() {
		return u.listaUsuarios();
	}

	public void setListaCorreos(List<Usuario> listaCorreos) {
		this.listaCorreos = listaCorreos;
	}

	public void setListaDocumentos(List<TipoDocumento> listaDocumentos) {
		this.listaDocumentos = listaDocumentos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginBean(List<com.david.sioca.app.model.Rol> listaRoles,
			List<com.david.sioca.app.model.TipoDocumento> listaDocumentos, Usuario usuario,
			com.david.sioca.app.model.Rol rol, com.david.sioca.app.model.TipoDocumento tipoDocumento) {
		super();
		this.listaRoles = listaRoles;
		this.listaDocumentos = listaDocumentos;
		this.usuario = usuario;
		Rol = rol;
		TipoDocumento = tipoDocumento;
	}
	
	public String registrarUsuario() {
		String verificar =usuario.getCorreo();
		String correo = "";
		String contraseña1=usuario.getContraseña();
		String contraseña2=usuario.getConfirmar();
		
		@SuppressWarnings("unused")
		boolean contador=false;
		Rol.setId(3);
		usuario.setRol(Rol);
		usuario.setTipoDocumento(TipoDocumento);
		listaCorreos = u.listaUsuarios();
		for (int i = 0; i < listaCorreos.size(); i++) {
			correo = listaCorreos.get(i).getCorreo();
			if(correo.equals(verificar)) {
				contador = true;
			}
		}
		if(contador == false) {
			System.out.println("contraseña: " + contraseña1 + "confirmacion: " + contraseña2);
			if(contraseña1.equals(contraseña2)){
				System.out.println("Entrando a crear");
				u.crearUsuario(usuario);
				return "login.xhtml?faces-redirect=true";
			}else {
				addMessage("Error", "Las contraseñas no coinciden");
			}
		}else {
			addMessage("Error", "El correo ya existe, ingresa otro porfavor");
		}
		listaCorreos.clear();
		return null;
	}
	
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	public String iniciarSesion() {
		String path = "";
		int usuarioRol = 0;
		usuarioRol = u.verificarDatos(usuario);
		HttpSession session = SessionUtils.getSession();
		switch (usuarioRol) {
		case (1):
			session.setAttribute("username", usuario.getNombres() + " " + usuario.getApellidos());
			path = "dashboardAdmin.xhtml?faces-redirect=true";
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioRol);
			break;
		case (2):
			session.setAttribute("username", usuario.getNombres() + " " + usuario.getApellidos());
			path = "dashboardVendedor.xhtml?faces-redirect=true";
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioRol);
			break;
		case (3):
			session.setAttribute("username", usuario.getNombres() + " " + usuario.getApellidos());
			path = "dashboardCliente.xhtml?faces-redirect=true";
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioRol);
			break;
		default:
			path = null;
			break;
		}
		return path;
	}

	public boolean verificarSesion() {
		boolean estado;

		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null) {
			estado = false;
		} else {
			estado = true;
		}
		return estado;
	}

	public String cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		System.out.println("Cerrando");
		return "/index.xhtml?faces-redirect=true";
	}
	
	
	
	
}
