package com.aljimez.T27C4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aljimez.T27C4.dao.ISuministraDAO;
import com.aljimez.T27C4.dto.Suministra;
@Service 
public class SuministraServiceImpl implements ISuministraService{

	@Autowired
	ISuministraDAO iSuministraDAO;
	
	@Override
	public List<Suministra> listarSuministra() {
		// TODO Auto-generated method stub
		return iSuministraDAO.findAll();
	}

	@Override
	public Suministra guardarSuministra(Suministra suministra) {
		// TODO Auto-generated method stub
		return iSuministraDAO.save(suministra);
	}

	@Override
	public Suministra suministraXID(Long id) {
		// TODO Auto-generated method stub
		return iSuministraDAO.findById(id).get();
	}

	@Override
	public Suministra actualizarSuministra(Suministra suministra) {
		// TODO Auto-generated method stub
		return iSuministraDAO.save(suministra);
	}

	@Override
	public void eliminarSuministra(Long id) {
		iSuministraDAO.deleteById(id);
	}

}
