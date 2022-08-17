package com.david.sioca.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.component.export.PDFOrientationType;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

import com.david.sioca.app.facadeImp.DetalleVentaImp;
import com.david.sioca.app.facadeImp.ProductoImp;
import com.david.sioca.app.facadeImp.VentaImp;
import com.david.sioca.app.model.DetalleVenta;
import com.david.sioca.app.model.Producto;
import com.david.sioca.app.model.Venta;

@ManagedBean(name = "ventaBean")
@RequestScoped
public class VentaBean {

	VentaImp ventaImp = new VentaImp();

	DetalleVentaImp detalleImp = new DetalleVentaImp();

	ProductoImp p = new ProductoImp();

	private Producto producto = new Producto();

	private Venta venta = new Venta();

	private DetalleVenta detalle = new DetalleVenta();

	private List<DetalleVenta> listaDetalles;

	private List<Venta> listaVentas;

	private List<Producto> listaProductos;

	private long total;

	private ExcelOptions excelOpt;

	private static List<Boolean> list = Arrays.asList(true, true, true, true, true);


	private PDFOptions pdfOpt;

	public PDFOptions getPdfOpt() {
		return pdfOpt;
	}

	public void setPdfOpt(PDFOptions pdfOpt) {
		this.pdfOpt = pdfOpt;
	}

	public List<Boolean> getList() {
		return list;
	}

	public ExcelOptions getExcelOpt() {
		return excelOpt;
	}

	public void setExcelOpt(ExcelOptions excelOpt) {
		this.excelOpt = excelOpt;
	}

	public VentaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VentaBean [ventaImp=" + ventaImp + ", detalleImp=" + detalleImp + ", producto=" + producto + ", venta="
				+ venta + ", detalle=" + detalle + ", listaDetalles=" + listaDetalles + ", listaVentas=" + listaVentas
				+ ", listaProductos=" + listaProductos + ", total=" + total + "]";
	}

	public List<Producto> getListaProductos() {
		ProductoImp p = new ProductoImp();
		return p.encontrarTodosProducto();
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public DetalleVenta getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleVenta detalle) {
		this.detalle = detalle;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public List<DetalleVenta> getListaDetalles() {
		return detalleImp.listaDetalleVentas();
	}

	public void setListaDetalles(List<DetalleVenta> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	public List<Venta> getListaVentas() {
		return ventaImp.listaVentas();
	}

	public void setListaVentas(List<Venta> listaVentas) {
		this.listaVentas = listaVentas;
	}

	public String nuevo() {
		System.out.println("Hola entrando a nuevo");
		return "registrar-venta.xhtml?faces-redirect=true";
	}

	public void actualizar(Venta ven) {
		ventaImp.editarVenta(ven);
	}

	public void borrar(int id) {
		ventaImp.borrarVenta(id);
		addMessage("Confirmado", "Venta borrada");
	}

	public String encontrar(int id) {
		venta = ventaImp.encontrarId(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("venta", venta);
		return "modificar-venta.xhtml?faces-redirect=true";
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void verDetalle(int id) {
		detalles.clear();
		List<DetalleVenta> l = new ArrayList<DetalleVenta>();
		l = ventaImp.listas(id);
		detalles.addAll(l);
	}

	private static final List<DetalleVenta> detalles = new ArrayList<>();

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void limpiar() {
		System.out.println("Entrando a limpiar");
		detalles.clear();
	}

	public long sumarVentas() {
		listaVentas = ventaImp.listaVentas();
		for (int i = 0; i < listaVentas.size(); i++) {
			total = total + listaVentas.get(i).getPrecio();
		}
		return total;
	}

	@PostConstruct
	public void init() {
		detalle = new DetalleVenta();
		venta = new Venta();
		producto = new Producto();
		customizationOptions();
	}

	public String actualizarDetalle() {
		DetalleVenta d = detalleImp.encontrarId(detalle.getIdDetalle());
		producto = p.encontrarProductoId(producto.getId_producto());
		venta = ventaImp.encontrarId(venta.getId());
		long total=0;
		int cantidad = detalle.getCantidad();
		int precio1 = producto.getPrice();
		long precio = cantidad*precio1;
		if (detalle.getCantidad() > d.getCantidad()) {
			int diferencia = detalle.getCantidad() - d.getCantidad();
			int cantidadProducto = producto.getQuantity() - diferencia;
			producto.setQuantity(cantidadProducto);
			p.editarProducto(producto);
		} else if (detalle.getCantidad() < d.getCantidad()) {
			int diferencia = d.getCantidad() - detalle.getCantidad();
			int cantidadProducto = producto.getQuantity() + diferencia;
			producto.setQuantity(cantidadProducto);
			p.editarProducto(producto);
		}
		detalle.setIdProducto(producto);
		detalle.setIdVenta(venta);
		detalle.setSubTotal(precio);
		detalleImp.editarDetalleVenta(detalle);
		this.listaDetalles= detalleImp.listaDetallesEspecial(venta.getId());
		for (int i = 0; i < this.listaDetalles.size(); i++) {
			total = total + this.listaDetalles.get(i).getSubTotal();
		}
		venta.setPrecio(total);
		ventaImp.editarVenta(venta);
		return "lista-ventas.xhtml?faces-redirect=true";
	}

	public void customizationOptions() {
		excelOpt = new ExcelOptions();
		// Titulos
		excelOpt.setFacetBgColor("#6D696A");
		excelOpt.setFacetFontSize("14");
		excelOpt.setFacetFontColor("#FFFFFF");
		excelOpt.setFacetFontStyle("BOLD");
		excelOpt.setFontName("Times New Roman");
		// Celdas
		excelOpt.setAutoSizeColumn(true);
		excelOpt.setCellFontSize("12");
		excelOpt.setCellFontStyle("Times New Roman");
		excelOpt.setStronglyTypedCells(true);

		pdfOpt = new PDFOptions();
		pdfOpt.setFacetBgColor("#F88017");
		pdfOpt.setFacetFontColor("#0000ff");
		pdfOpt.setFacetFontStyle("BOLD");
		pdfOpt.setCellFontSize("12");
		pdfOpt.setFontName("Courier");
		pdfOpt.setOrientation(PDFOrientationType.LANDSCAPE);
	}

	public void onToggle(ToggleEvent e) {
		list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
	}

	public String reiniciarTabla() {
		list = Arrays.asList(true, true, true, true, true);
		return "lista-ventas.xhtml?faces-redirect=true";
	}

}
