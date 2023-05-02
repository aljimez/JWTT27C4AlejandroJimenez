package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraService {

	// Metodos del CRUD
	public List<MaquinaRegistradora> listarMaquina(); // Listar All

	public MaquinaRegistradora guardarMaquina(MaquinaRegistradora maquina); // Guarda un proveedor CREATE

	public MaquinaRegistradora actualizarMaquina(MaquinaRegistradora maquina); // Actualiza datos del proveedor UPDATE

	MaquinaRegistradora maquinaXID(Long id);

	void eliminarMaquina(Long id);
}
