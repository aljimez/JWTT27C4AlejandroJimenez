package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.Proveedores;

public interface IProveedoresService {

	public List<Proveedores> listarProveedores(); // Listar All

	public Proveedores guardarProveedores(Proveedores proveedores); // Guarda un Estudiante CREATE

	public Proveedores actualizarProveedores(Proveedores proveedores); // Actualiza datos del estudiante UPDATE
	
	void eliminarProveedores(Long id);

	Proveedores proveedoresXID(Long id);

}
