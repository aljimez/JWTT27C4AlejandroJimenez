package com.aljimez.T27C4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aljimez.T27C4.dao.IVentasDAO;
import com.aljimez.T27C4.dto.Ventas;

public class VentasServiceImpl implements IVentasService{

	@Autowired
	IVentasDAO iVentaDAO;
	
	@Override
	public List<Ventas> listarVenta() {
		// TODO Auto-generated method stub
		return iVentaDAO.findAll();
	}

	@Override
	public Ventas guardarVenta(Ventas venta) {
		// TODO Auto-generated method stub
		return iVentaDAO.save(venta);
	}

	@Override
	public Ventas ventaXID(Long id) {
		// TODO Auto-generated method stub
		return iVentaDAO.findById(id).get();
	}

	@Override
	public Ventas actualizarVenta(Ventas venta) {
		// TODO Auto-generated method stub
		return iVentaDAO.save(venta);
	}

	@Override
	public void eliminarVenta(Long id) {
		// TODO Auto-generated method stub
		iVentaDAO.deleteById(id);
	}

}
