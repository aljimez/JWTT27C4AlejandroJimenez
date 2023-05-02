package com.aljimez.T27C4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aljimez.T27C4.dao.ICientificosDAO;
import com.aljimez.T27C4.dto.Cientificos;
@Service
public class CientificosServiceImpl {

	
	@Autowired
	ICientificosDAO iCientificosDAO;
	public void eliminarCientifico(Long id) {
		// TODO Auto-generated method stub
		iCientificosDAO.deleteById(id);

	}

	public Cientificos actualizarCientifico(Cientificos cientifico_seleccionado) {
		// TODO Auto-generated method stub
		return iCientificosDAO.save(cientifico_seleccionado);
	}

	public Cientificos cientificoXID(Long id) {
		// TODO Auto-generated method stub
		return iCientificosDAO.findById(id).get();
	}

	public Cientificos guardarCientifico(Cientificos cientifico) {
		// TODO Auto-generated method stub
		return iCientificosDAO.save(cientifico);
	}

	public List<Cientificos> listarCientificos() {
		// TODO Auto-generated method stub
		return iCientificosDAO.findAll();
	}

}
