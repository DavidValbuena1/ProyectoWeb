package com.david.sioca.app.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

import com.david.sioca.app.facadeImp.CategoriaImp;
import com.david.sioca.app.facadeImp.DetalleVentaImp;
import com.david.sioca.app.facadeImp.ProductoImp;
import com.david.sioca.app.facadeImp.ProveedorImp;
import com.david.sioca.app.facadeImp.VentaImp;
import com.david.sioca.app.model.Categoria;
import com.david.sioca.app.model.DetalleVenta;
import com.david.sioca.app.model.Producto;
import com.david.sioca.app.model.Proveedor;
import com.david.sioca.app.model.Venta;

@ManagedBean(name = "productoBean")
@RequestScoped
public class ProductoBean {

	ProductoImp p = new ProductoImp();

	private List<Categoria> listaProductos;

	private List<Proveedor> listaProveedores;

	private List<Producto> listaP;

	private Venta venta = new Venta();

	private Venta venta2 = new Venta();

	private Producto producto = new Producto();

	private Categoria categoria = new Categoria();

	private Proveedor proveedor = new Proveedor();
	
	private static List<Boolean> list = Arrays.asList(true,true,true,true,true,true,true,true,true,true,true);

	public ProductoBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductoBean [listaProductos=" + listaProductos + ", listaProveedores=" + listaProveedores + ", listaP="
				+ listaP + ", venta=" + venta + ", producto=" + producto + ", categoria=" + categoria + ", proveedor="
				+ proveedor + "]";
	}
	
	
	public List<Boolean> getList() {
		return list;
	}


	public Venta getVenta2() {
		return venta2;
	}

	public void setVenta2(Venta venta2) {
		this.venta2 = venta2;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public List<Categoria> getListaProductos() {
		CategoriaImp c = new CategoriaImp();
		return c.listacategoria();
	}

	public void setListaProductos(List<Categoria> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<Proveedor> getListaProveedores() {
		ProveedorImp p = new ProveedorImp();
		return p.encontrar();
	}

	public void setListaProveedores(List<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Producto> encontrarTodos() {
		ProductoImp product = new ProductoImp();
		return product.encontrarTodosProducto();
	}

	public String nuevo() {
		return "registrar-productos.xhtml?faces-redirect=true";
	}

	public String CrearProducto() {
		long precio1 = producto.getPrice();
		long cantidad = producto.getQuantity();
		long preciofinal = precio1 * cantidad;
		Date fecha = new Date();
		producto.setPrecioTotal(preciofinal);
		producto.setDate(fecha);
		producto.setProveedor(proveedor);
		producto.setType(categoria);
		p.crearProducto(producto);
		this.producto = new Producto();
		this.proveedor = new Proveedor();
		this.categoria = new Categoria();
		return "lista-productos.xhtml?faces-redirect=true";
	}

	public String encontrar(int id, Producto productos) {
		producto = p.encontrarProductoId(id);
		proveedor.setId_proveedor(productos.getProveedor().getId_proveedor());
		categoria.setId(productos.getType().getId());
		producto = productos;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", producto);
		return "modificar-productos.xhtml?faces-redirect=true";
	}

	public void encontrar2() {
		producto = p.encontrarProductoId(producto.getId_producto());
		if (producto!=null) {
			addMessage("Confirmado", "Producto encontrado");
		}else {
			addMessageError("Error", "Producto no encontrado");
		}
	}

	private static final ArrayList<Producto> productos = new ArrayList<Producto>();

	public void agregar() {
		long precio1 = producto.getPrice();
		long cantidad1 = producto.getQuantity();
		long precio = precio1 * cantidad1;
		Producto p2 = new Producto();
		p2 = p.encontrarProductoId(producto.getId_producto());
		if(producto.getQuantity()>0 ) {
			if(producto.getQuantity()<=p2.getQuantity()) {
				producto.setPrecioTotal(precio);
				productos.add(producto);
				addMessage("Confirmado", "Producto Agregado");
			}else {
				addMessageError("Error", "La cantidad no puede ser mayor que " + p2.getQuantity());
			}
		}else {
			addMessageError("Error", "La cantidad no puede ser menor o igual que 0");
		}
	}

	public String editar(Producto producto) {
		long mili = System.currentTimeMillis();
		Date fecha = new Date(mili);
		producto.setDate(fecha);
		producto.setProveedor(proveedor);
		producto.setType(categoria);
		System.out.println("Editando..." + producto.toString());
		p.editarProducto(producto);
		this.producto = new Producto();
		this.proveedor = new Proveedor();
		this.categoria = new Categoria();
		return "lista-productos.xhtml?faces-redirect=true";
	}

	public String delete(long id) {
		p.delete(id);
		addMessage("Confirmado", "Producto Borrado");
		return "lista-productos.xhtml?faces-redirect=true";
	}

	public void addMessageError(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<Producto> getListaP() {
		return p.encontrarTodosProducto();
	}

	public void setListaP(List<Producto> listaP) {
		this.listaP = listaP;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void limpiar() {
		productos.clear();
	}

	public void generarVenta() {
		VentaImp ventaImp = new VentaImp();
		DetalleVentaImp dtImp = new DetalleVentaImp();
		long total = 0;
		String estado = "Completada";
		Date fecha = new Date();
		for (int i = 0; i < productos.size(); i++) {
			total = total + productos.get(i).getPrecioTotal();
		}
		// Insertar Venta
		venta.setEstado(estado);
		System.out.println("Hola");
		venta.setFecha(fecha);
		venta.setPrecio(total);
		ventaImp.crearVenta(venta);
		int idventa = ventaImp.IdVenta();
		venta2 = ventaImp.encontrarId(idventa);
		int cantidad2=0;
		int restaC=0;
		// Insertar DetalleVenta
		for (int i = 0; i < productos.size(); i++) {
			DetalleVenta dv = new DetalleVenta();
			dv.setCantidad(productos.get(i).getQuantity());
			dv.setIdVenta(venta2);
			long idproducto = productos.get(i).getId_producto();
			producto = p.encontrarProductoId(idproducto);
			dv.setIdProducto(producto);
			total = productos.get(i).getPrecioTotal();
			dv.setSubTotal(total);
			cantidad2 = cantidad2+productos.get(i).getQuantity();
			restaC = producto.getQuantity()-cantidad2;
			producto.setQuantity(restaC);
			long precio = restaC*producto.getPrice();
			producto.setPrecioTotal(precio);
			p.editarProducto(producto);
			dtImp.crearVenta(dv);
			cantidad2=0;
			restaC=0;
		}
		addMessage("Registrada", "Venta registrada con el ID " + venta.getId());
		productos.clear();
	}
	
	public void quitarDetalle(int id) {
		for (int i = 0; i < productos.size(); i++) {
			long id2 = productos.get(i).getId_producto();
			if(id == id2) {
				productos.remove(i);
				addMessage("Quitado", "Producto con el ID " + id + " quitado de la factura");
			}
		}
	}
	
	public void onToggle(ToggleEvent e) {
		list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	public String reiniciarTabla() {
		list = Arrays.asList(true,true, true, true, true, true,true,true,true,true,true);
		return "lista-productos.xhtml?faces-redirect=true";
	}

}
