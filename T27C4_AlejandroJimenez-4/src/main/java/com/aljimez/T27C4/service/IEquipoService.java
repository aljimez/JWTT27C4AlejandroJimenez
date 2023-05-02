package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.Equipos;

public interface IEquipoService {

	
	public List<Equipos> listarEquipo();

	public Equipos guardarEquipo(Equipos equipo);

	public Equipos equiposXID(Long id);

	public Equipos actualizarEquipo(Equipos equipo);

	public void eliminarEquipo(Long id);
}
