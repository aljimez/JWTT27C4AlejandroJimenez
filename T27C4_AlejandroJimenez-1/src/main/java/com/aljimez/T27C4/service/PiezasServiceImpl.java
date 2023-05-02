package com.aljimez.T27C4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aljimez.T27C4.dao.IPiezasDAO;
import com.aljimez.T27C4.dto.Piezas;

@Service
public class PiezasServiceImpl implements IPiezasService {

	@Autowired
	IPiezasDAO iPiezasDAO;

	@Override
	public List<Piezas> listPiezas() {
		return iPiezasDAO.findAll();
	}

	@Override
	public Piezas guardarPiezas(Piezas piezas) {
		// TODO Auto-generated method stub
		return iPiezasDAO.save(piezas);
	}

	@Override
	public Piezas piezasXID(Long id) {
		// TODO Auto-generated method stub
		return iPiezasDAO.findById(id).get();
	}

	@Override
	public Piezas actualizarPiezas(Piezas piezas) {
		// TODO Auto-generated method stub
		return iPiezasDAO.save(piezas);
	}

	@Override
	public void eliminarPieza(Long id) {
		// TODO Auto-generated method stub
		iPiezasDAO.deleteById(id);
	}

}
