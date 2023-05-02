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

import com.aljimez.T27C4.dto.Cientificos;
import com.aljimez.T27C4.service.CientificosServiceImpl;

@RestController
@RequestMapping("/api")
public class CientificosController {

	

	@Autowired
	CientificosServiceImpl cientificosServiceImpl;
	

	@GetMapping("/cientificos")
	public List<Cientificos> listarCientifico() {
		return cientificosServiceImpl.listarCientificos();
	}
	

	@PostMapping("/cientificos")
	public Cientificos saveCientifico(@RequestBody Cientificos cientifico) {
		return cientificosServiceImpl.guardarCientifico(cientifico);
	}
	
	@GetMapping("/cientificos/{id}")
	public Cientificos cientificoXID(@PathVariable(name = "id") Long id) {
		Cientificos cientificos = new Cientificos();
		cientificos = cientificosServiceImpl.cientificoXID(id);
		return cientificos;
	}
	

	@PutMapping("/cientificos/{id}")
	public Cientificos actualizarCientifico(@PathVariable(name = "id") Long id, @RequestBody Cientificos cientifico) {

		Cientificos cientifico_seleccionado = new Cientificos();
		Cientificos cientifico_actualizado = new Cientificos();
		cientifico_seleccionado = cientificosServiceImpl.cientificoXID(id);
		cientifico_seleccionado.setDni(cientifico.getDni());
		cientifico_seleccionado.setNombreApellidos(cientifico.getNombreApellidos());
		


		cientifico_actualizado = cientificosServiceImpl.actualizarCientifico(cientifico_seleccionado);

		return cientifico_actualizado;
	}
	@DeleteMapping("/cientificos/{id}")
	public void eliminarCientifico(@PathVariable(name = "id") Long id) {
		cientificosServiceImpl.eliminarCientifico(id);
	}
}
