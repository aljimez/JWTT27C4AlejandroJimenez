package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dao.IFacultadDAO;
import com.aljimez.T27C4.dto.Facultad;

public class FacultadServiceImpl implements IFacultadService{

	IFacultadDAO iFacultadDAO;
	
	
	@Override
	public List<Facultad> listarFacultad() {
		// TODO Auto-generated method stub
		return iFacultadDAO.findAll();
	}

	@Override
	public Facultad guardarFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		return iFacultadDAO.save(facultad);
	}

	@Override
	public Facultad facultadXID(Long id) {
		// TODO Auto-generated method stub
		return iFacultadDAO.findById(id).get();
	}

	@Override
	public Facultad actualizarFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		return iFacultadDAO.save(facultad);
	}

	@Override
	public void eliminarFacultad(Long id) {
		// TODO Auto-generated method stub
		iFacultadDAO.deleteById(id);
	}

}
