package com.aljimez.T27C4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aljimez.T27C4.dao.IProveedoresDAO;
import com.aljimez.T27C4.dto.Proveedores;
@Service
public class ProveedoresServiceImpl implements IProveedoresService{

	@Autowired
	IProveedoresDAO iProveedoresDAO;
	
	@Override
	public List<Proveedores> listarProveedores() {
		// TODO Auto-generated method stub
		return iProveedoresDAO.findAll();
	}

	@Override
	public Proveedores guardarProveedores(Proveedores proveedores) {
		// TODO Auto-generated method stub
		return iProveedoresDAO.save(proveedores);
	}

	@Override
	public Proveedores proveedoresXID(Long id) {
		// TODO Auto-generated method stub
		return iProveedoresDAO.findById(id).get();
	}

	@Override
	public Proveedores actualizarProveedores(Proveedores proveedores) {
		// TODO Auto-generated method stub
		return iProveedoresDAO.save(proveedores);
	}

	@Override
	public void eliminarProveedores(Long id) {
		// TODO Auto-generated method stub
		iProveedoresDAO.deleteById(id);
	}

}
