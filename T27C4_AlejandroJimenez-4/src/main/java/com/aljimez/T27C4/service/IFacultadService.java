package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.Facultad;

public interface IFacultadService {
	public List<Facultad> listarFacultad();

	public Facultad guardarFacultad(Facultad facultad);

	public Facultad facultadXID(Long id);

	public Facultad actualizarFacultad(Facultad facultad);

	public void eliminarFacultad(Long id);
}
