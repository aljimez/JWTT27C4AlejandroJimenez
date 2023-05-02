package com.aljimez.T27C4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aljimez.T27C4.dao.IAsignadoaDAO;
import com.aljimez.T27C4.dto.Asignadoa;
@Service
public class AsignadoaServiceImpl implements IAsignadoaService {
	@Autowired
	IAsignadoaDAO iAsignadoaDAO;

	@Override
	public List<Asignadoa> listarAsignado() {
		return iAsignadoaDAO.findAll();
	}

	@Override
	public Asignadoa guardarAsignado(Asignadoa asignado) {
		return iAsignadoaDAO.save(asignado);
	}

	@Override
	public Asignadoa asignadoaXID(Long id) {
		return iAsignadoaDAO.findById(id).get();
	}

	@Override
	public Asignadoa actualizarAsignado(Asignadoa asignado) {
		return iAsignadoaDAO.save(asignado);
	}

	@Override
	public void eliminarAsignado(Long id) {
		iAsignadoaDAO.deleteById(id);

	}

	

	
}
