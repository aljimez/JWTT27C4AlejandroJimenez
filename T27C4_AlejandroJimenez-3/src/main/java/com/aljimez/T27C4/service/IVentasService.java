package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.Ventas;

public interface IVentasService {

	// Metodos del CRUD
	public List<Ventas> listarVenta(); // Listar All

	public Ventas guardarVenta(Ventas venta); // Guarda un suministra CREATE

	public Ventas actualizarVenta(Ventas venta); // Actualiza datos del suministra UPDATE

	public void eliminarVenta(Long id);// Elimina el suministra DELETE

	Ventas ventaXID(Long id);

}
