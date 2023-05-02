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

import com.aljimez.T27C4.dto.Proveedores;
import com.aljimez.T27C4.service.ProveedoresServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedoresController {

	@Autowired
	ProveedoresServiceImpl proveedoresServiceImpl;

	@GetMapping("/proveedores")
	public List<Proveedores> listarProveedores() {
		return proveedoresServiceImpl.listarProveedores();
	}

	@PostMapping("/proveedores")
	public Proveedores salvarProveedores(@RequestBody Proveedores proveedores) {
		return proveedoresServiceImpl.guardarProveedores(proveedores);

	}

	@GetMapping("/proveedores/{id}")
	public Proveedores proveedoresXID(@PathVariable(name = "id") Long id) {

		Proveedores	proveedoresxID = proveedoresServiceImpl.proveedoresXID(id);
		
		proveedoresServiceImpl.proveedoresXID(id);

		return proveedoresxID;
	}

	@PutMapping("/proveedores/{id}")
	public Proveedores actualizarProveedores(@PathVariable(name = "id") Long id, @RequestBody Proveedores proveedores) {

		Proveedores Proveedores_seleccionado = new Proveedores();
		Proveedores Proveedores_update = new Proveedores();

		Proveedores_seleccionado = proveedoresServiceImpl.proveedoresXID(id);

		Proveedores_seleccionado.setNombre(proveedores.getNombre());

		Proveedores_update = proveedoresServiceImpl.actualizarProveedores(Proveedores_seleccionado);

		return Proveedores_update;

	}

	@DeleteMapping("/proveedores/{id}")
	public void eleiminarCurso(@PathVariable(name="id")Long id) {
		proveedoresServiceImpl.eliminarProveedores(id);
	}
	
	
}
