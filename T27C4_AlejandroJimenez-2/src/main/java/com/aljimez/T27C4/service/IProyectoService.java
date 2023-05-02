package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.Proyectos;

public interface IProyectoService {
	public List<Proyectos> listarProyecto();

	public Proyectos guardarProyecto(Proyectos proyecto);

	public Proyectos proveedorById(int id);

	public Proyectos actualizarProyecto(Proyectos proyecto);

	public void eliminarProyecto(int id);
}
