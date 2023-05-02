package com.aljimez.T27C4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aljimez.T27C4.dao.IMaquinaRegistradoraDAO;
import com.aljimez.T27C4.dto.MaquinaRegistradora;

public class MaquinaRegistradoraServiceImpl implements IMaquinaRegistradoraService {

	
	@Autowired
	IMaquinaRegistradoraDAO iMaquinaRegistradoraDAO;
	@Override
	public List<MaquinaRegistradora> listarMaquina() {
		// TODO Auto-generated method stub
		return iMaquinaRegistradoraDAO.findAll();
	}

	@Override
	public MaquinaRegistradora guardarMaquina(MaquinaRegistradora maquina) {
		// TODO Auto-generated method stub
		return iMaquinaRegistradoraDAO.save(maquina);
	}

	@Override
	public MaquinaRegistradora maquinaXID(Long id) {
		// TODO Auto-generated method stub
		return iMaquinaRegistradoraDAO.findById(id).get();
	}

	@Override
	public MaquinaRegistradora actualizarMaquina(MaquinaRegistradora maquina) {
		// TODO Auto-generated method stub
		return iMaquinaRegistradoraDAO.save(maquina);
	}

	@Override
	public void eliminarMaquina(Long id) {
		// TODO Auto-generated method stub
		iMaquinaRegistradoraDAO.deleteById(id);
	}

}
