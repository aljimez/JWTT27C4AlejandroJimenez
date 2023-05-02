package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.Suministra;

public interface ISuministraService {
	
public List<Suministra> listarSuministra(); //Listar All 
	
	public Suministra guardarSuministra(Suministra suministra);	//Guarda un Estudiante CREATE
	
	public Suministra suministraXID(Long id); //Leer datos de un Estudiante READ
	
	public Suministra actualizarSuministra(Suministra suministra); //Actualiza datos del estudiante UPDATE
	
	public void eliminarSuministra(Long id);// Elimina el estudiante DELETE


	
}
