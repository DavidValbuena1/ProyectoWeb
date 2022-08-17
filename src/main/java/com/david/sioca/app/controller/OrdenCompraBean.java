package com.david.sioca.app.controller;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

import com.david.sioca.app.facadeImp.OrdenImp;
import com.david.sioca.app.facadeImp.ProveedorImp;
import com.david.sioca.app.model.OrdenCompra;
import com.david.sioca.app.model.Proveedor;

@ManagedBean(name = "ordenBean")
@RequestScoped
public class OrdenCompraBean {

	OrdenImp ordenImp = new OrdenImp();

	private List<Proveedor> listaProveedores;

	private List<OrdenCompra> listaP;

	private static List<Boolean> list = Arrays.asList(true, true, true, true, true, true, true, true);
	
	public List<Boolean> getList() {
		return list;
	}


	public List<OrdenCompra> getListaP() {
		return listaP;
	}

	public void setListaP(List<OrdenCompra> listaP) {
		this.listaP = listaP;
	}

	private OrdenCompra orden = new OrdenCompra();

	private Proveedor proveedor = new Proveedor();

	public List<Proveedor> getListaProveedores() {
		ProveedorImp p = new ProveedorImp();
		return p.encontrar();
	}

	public void setListaProveedores(List<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public OrdenCompra getOrden() {
		return orden;
	}

	public void setOrden(OrdenCompra orden) {
		this.orden = orden;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public OrdenCompraBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdenCompraBean(List<Proveedor> listaProveedores, OrdenCompra orden, Proveedor proveedor) {
		super();
		this.listaProveedores = listaProveedores;
		this.orden = orden;
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "OrdenCompraBean [ordenImp=" + ordenImp + ", listaProveedores=" + listaProveedores + ", orden=" + orden
				+ ", proveedor=" + proveedor + "]";
	}

	public String crear() {
		int cantidad = orden.getCantidadProductos();
		long precio1 = orden.getPrecioUnidad();
		long precio2 = cantidad * precio1;
		orden.setPrecioTotal(precio2);
		orden.setProveedor(proveedor);
		orden.setEstado(false);
		ordenImp.crearOrden(orden);
		orden = new OrdenCompra();
		proveedor = new Proveedor();
		return "orden.xhtml?faces-redirect=true";
	}

	public String encontrar(int id, OrdenCompra ordenC) {
		orden = ordenImp.encontrarOrden(id);
		proveedor.setId_proveedor(ordenC.getProveedor().getId_proveedor());
		orden.setProveedor(proveedor);
		orden = ordenC;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("orden", orden);
		return "modificar-orden.xhtml?faces-redirect=true";
	}

	public String editar(OrdenCompra ordenC) {
		int cantidad = ordenC.getCantidadProductos();
		long precio1 = ordenC.getPrecioUnidad();
		long precio2 = cantidad * precio1;
		ordenC.setPrecioTotal(precio2);
		ordenC.setProveedor(proveedor);
		ordenImp.editarOrden(ordenC);
		orden = new OrdenCompra();
		proveedor = new Proveedor();
		return "orden.xhtml?faces-redirect=true";
	}

	public String nuevo() {
		return "registrar-orden.xhtml?faces-redirect=true";
	}

	public void borrar(int id) {
		ordenImp.borrarOrden(id);
	}

	public List<OrdenCompra> encontrarTodos() {
		List<OrdenCompra> lista = new ArrayList<OrdenCompra>();
		lista = ordenImp.encontrarOrdenes();
		return lista;
	}

	public void onToggle(ToggleEvent e) {
		list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	public String reiniciarTabla() {
		list = Arrays.asList(true, true, true, true, true, true, true, true);
		return "orden.xhtml?faces-redirect=true";
	}

}
