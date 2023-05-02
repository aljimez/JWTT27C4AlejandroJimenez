package com.aljimez.T27C4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aljimez.T27C4.dao.IProyectosDAO;
import com.aljimez.T27C4.dto.Proyectos;
@Service
public class ProyectoServiceImpl {

	
	@Autowired
	IProyectosDAO iProyectoDAO;
	public void eliminarProyectos(Long id) {
		// TODO Auto-generated method stub
		iProyectoDAO.deleteById(id);

	}

	public Proyectos actualizarProyectos(Proyectos proyecto_seleccionado) {
		// TODO Auto-generated method stub
		return iProyectoDAO.save(proyecto_seleccionado);
	}

	public Proyectos proyectosXID(Long id) {
		// TODO Auto-generated method stub
		return iProyectoDAO.findById(id).get();
	}

	public List<Proyectos> listarProyecto() {
		// TODO Auto-generated method stub
		return iProyectoDAO.findAll();
	}

	public Proyectos guardarProyectos(Proyectos proyecto) {
		// TODO Auto-generated method stub
		return iProyectoDAO.save(proyecto);
	}

}
