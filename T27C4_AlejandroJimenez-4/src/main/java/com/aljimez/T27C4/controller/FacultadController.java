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

import com.aljimez.T27C4.dto.Facultad;
import com.aljimez.T27C4.service.FacultadServiceImpl;



@RestController
@RequestMapping("/api")
public class FacultadController {

	
	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	

	@GetMapping("/facultades")
	public List<Facultad> listarFacultad() {
		return facultadServiceImpl.listarFacultad();
	}
	
	@PostMapping("/facultades")
	public Facultad guardarFacultad(@RequestBody Facultad facultad) {
		return facultadServiceImpl.guardarFacultad(facultad);
	}
	
	@GetMapping("/facultades/{id}")
	public Facultad facultadById(@PathVariable(name = "codigo") Long id) {
		Facultad facultad = new Facultad();
		facultad = facultadServiceImpl.facultadXID(id);
		return facultad;
	}
	
	@PutMapping("/facultades/{id}")
	public Facultad actualizarFacultad(@PathVariable(name = "id") Long id, @RequestBody Facultad facultad) {

		 
		Facultad facultad_seleccionado = facultadServiceImpl.facultadXID(id);
		facultad_seleccionado.setCodigo(id);
		facultad_seleccionado.setEquipo(facultad.getEquipo());
		facultad_seleccionado.setInvestigador(facultad.getInvestigador());
		facultad_seleccionado.setNombre(facultad.getNombre());

		Facultad	facultad_actualizado = facultadServiceImpl.actualizarFacultad(facultad_seleccionado);

		return facultad_actualizado;
	}
	
	@DeleteMapping("/facultades/{id}")
	public void eliminarFacultad(@PathVariable(name = "id") Long id) {
		facultadServiceImpl.eliminarFacultad(id);
	}

}
