package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.Cajero;

public interface ICajeroService {

	// Metodos del CRUD
	public List<Cajero> listarCajero(); // Listar All

	public Cajero guardarCajero(Cajero cajero); // Guarda un departamento CREATE

	public Cajero actualizarCajero(Cajero cajero); // Actualiza datos del departamento UPDATE

	void eliminarCajero(Long id);

	Cajero cajeroXID(Long id);

}
