package com.aljimez.T27C4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aljimez.T27C4.dao.IEquipoDAO;
import com.aljimez.T27C4.dto.Equipos;

public class EquipoServiceImpl implements IEquipoService{
@Autowired
	IEquipoDAO iEquipoDAO;
	@Override
	public List<Equipos> listarEquipo() {
		// TODO Auto-generated method stub
		return iEquipoDAO.findAll();
	}

	@Override
	public Equipos guardarEquipo(Equipos equipo) {
		// TODO Auto-generated method stub
		return iEquipoDAO.save(equipo);
	}

	
	@Override
	public Equipos actualizarEquipo(Equipos equipo) {
		// TODO Auto-generated method stub
		return iEquipoDAO.save(equipo);
	}

	@Override
	public void eliminarEquipo(Long id) {
		// TODO Auto-generated method stub
		iEquipoDAO.deleteById(id);
	}

	public Equipos equiposXID(Long id) {
		// TODO Auto-generated method stub
		return iEquipoDAO.findById(id).get();
	}

}
