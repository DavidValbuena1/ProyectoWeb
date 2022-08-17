package com.david.sioca.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

import com.david.sioca.app.facadeImp.CategoriaImp;
import com.david.sioca.app.facadeImp.ProveedorImp;
import com.david.sioca.app.model.Categoria;
import com.david.sioca.app.model.Proveedor;

@ManagedBean(name = "proveedorBean")
@RequestScoped
public class ProveedorBean {

	ProveedorImp p = new ProveedorImp();

	private Proveedor proveedor = new Proveedor();

	private Categoria categoria = new Categoria();

	private List<Categoria> listaProductos;
	
	private List<Proveedor> listaP;
	
	private static List<Boolean> list = Arrays.asList(true, true, true, true, true,true, true, true, true, true,true);

	public List<Boolean> getList() {
		return list;
	}

	public List<Proveedor> getListaP() {
		return listaP;
	}

	public void setListaP(List<Proveedor> listaP) {
		this.listaP = listaP;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaProductos() {
		CategoriaImp c = new CategoriaImp();
		return c.listacategoria();
	}

	public void setListaProductos(List<Categoria> listaProductos) {
		this.listaProductos = listaProductos;
	}

	@Override
	public String toString() {
		return "ProveedorBean [p=" + p + ", proveedor=" + proveedor + ", categoria=" + categoria + ", listaProductos="
				+ listaProductos + "]";
	}

	public ProveedorBean(Proveedor proveedor, Categoria categoria, List<Categoria> listaProductos) {
		super();
		this.proveedor = proveedor;
		this.categoria = categoria;
		this.listaProductos = listaProductos;
	}

	public ProveedorBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Proveedor> encontrar() {
		ProveedorImp p = new ProveedorImp();
		return p.encontrar();
	}

	public String nuevo() {
		return "registrar-proveedores.xhtml?faces-redirect=true";
	}

	public String crear() {
		System.out.println("Datos: " + toString());
		proveedor.setCategoria(categoria);
		p.crearProveedor(proveedor);
		this.categoria = new Categoria();
		this.proveedor = new Proveedor();
		return "lista-proveedores.xhtml?faces-redirect=true";
	}

	public String encontrarId(int id, Proveedor pro) {
		proveedor = p.encontrarPorId(id);
		categoria.setId(pro.getCategoria().getId());
		proveedor = pro;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("proveedor", proveedor);
		return "modificar-proveedores.xhtml?faces-redirect=true";
	}

	public String actualizar(Proveedor proveedor) {
		proveedor.setCategoria(categoria);
		p.editarProveedor(proveedor);
		this.proveedor = new Proveedor();
		this.categoria = new Categoria();
		return "lista-proveedores.xhtml?faces-redirect=true";
	}

	public void borrar(int id) {
		try {
			p.delete(id);
			addMessage("Confirmado", "Proveedor Borrado");
		}catch(Exception e){
			addMessageError("Error", "El proveedor no puede ser borrado");
		}
	}

	public void addMessageError(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void onToggle(ToggleEvent e) {
		list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	public String reiniciarTabla() {
		list = Arrays.asList(true, true, true, true, true,true, true, true, true, true,true);
		return "lista-proveedores.xhtml?faces-redirect=true";
	}
}
