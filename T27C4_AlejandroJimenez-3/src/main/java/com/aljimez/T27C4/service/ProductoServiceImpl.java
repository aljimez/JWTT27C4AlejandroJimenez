package com.aljimez.T27C4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aljimez.T27C4.dao.IProductoDAO;
import com.aljimez.T27C4.dto.Producto;

public class ProductoServiceImpl implements IProductoService{

	@Autowired
	
	IProductoDAO iProductoDAO;
	
	
	@Override
	public List<Producto> listarProducto() {
		// TODO Auto-generated method stub
		return iProductoDAO.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return iProductoDAO.save(producto);
	}

	@Override
	public Producto productoXID(Long id) {
		// TODO Auto-generated method stub
		return iProductoDAO.findById(id).get();
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return iProductoDAO.save(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		iProductoDAO.deleteById(id);
	}

}
