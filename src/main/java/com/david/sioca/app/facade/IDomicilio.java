package com.david.sioca.app.facade;

import java.util.List;

import com.david.sioca.app.model.Domicilio;

public interface IDomicilio {
	public List<Domicilio> listaDomicilios();
	public Domicilio encontrarId(int id);
	public void crearDomicilio(Domicilio domicilio);
	public void borrarDomicilio(int id);
	public void editarDomicilio(Domicilio domicilio);
}
