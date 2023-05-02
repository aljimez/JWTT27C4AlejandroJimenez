package com.aljimez.T27C4.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aljimez.T27C4.dto.MaquinaRegistradora;
import com.aljimez.T27C4.service.MaquinaRegistradoraServiceImpl;


@RestController
@RequestMapping("/api")
public class MaquinaRegistradoraController {

	

	@Autowired
	MaquinaRegistradoraServiceImpl maquinaServiceImpl;
	
	

	@GetMapping("/maquinas")
	public List<MaquinaRegistradora> listarMaquina() {
		return maquinaServiceImpl.listarMaquina();
	}
	


	@PostMapping("/maquinas")
	public MaquinaRegistradora guardarMaquina(@RequestBody MaquinaRegistradora maquina) {
		return maquinaServiceImpl.guardarMaquina(maquina);
	}
	

	@GetMapping("/maquinas/{id}")
	public MaquinaRegistradora maquinaById(@PathVariable(name = "id") Long id) {
		MaquinaRegistradora	maquina = maquinaServiceImpl.maquinaXID(id);
		return maquina;
	}
	

	@PutMapping("/maquinas/{id}")
	public MaquinaRegistradora actualizarMaquina(@PathVariable(name = "id") Long id, @RequestBody MaquinaRegistradora maquina) {

	
		MaquinaRegistradora maquina_seleccionado = maquinaServiceImpl.maquinaXID(id);

		maquina_seleccionado.setCodigo(id);
		maquina_seleccionado.setPiso(maquina.getPiso());
		maquina_seleccionado.setVenta(maquina.getVenta());

		MaquinaRegistradora	maquina_actualizado = maquinaServiceImpl.actualizarMaquina(maquina_seleccionado);
		return maquina_actualizado;
	}
	
	@DeleteMapping("/maquinas/{id}")
	public void eliminarMaquina(@PathVariable(name = "id") Long id) {
		maquinaServiceImpl.eliminarMaquina(id);
	}
}
