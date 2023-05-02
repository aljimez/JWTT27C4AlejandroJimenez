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

import com.aljimez.T27C4.dto.Equipos;
import com.aljimez.T27C4.service.EquipoServiceImpl;


@RestController
@RequestMapping("/api")
public class EquipoController {

	

	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	

	@GetMapping("/equipos")
	public List<Equipos> listarEquipos() {
		return equipoServiceImpl.listarEquipo();
	}
	
	@PostMapping("/equipos")
	public Equipos guardarEquipos(@RequestBody Equipos equipo) {
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	

	@GetMapping("/equipos/{id}")
	public Equipos equipoById(@PathVariable(name = "id") Long id) {
		Equipos equipo = equipoServiceImpl.equiposXID(id);
		return equipo;
	}
	

	@PutMapping("/equipos/{id}")
	public Equipos actualizarEquipos(@PathVariable(name = "id") Long id, @RequestBody Equipos equipo) {

		
		Equipos	equipo_seleccionado = equipoServiceImpl.equiposXID(id);
		equipo_seleccionado.setId(id);
		equipo_seleccionado.setFacultad(equipo.getFacultad());
		equipo_seleccionado.setNombre(equipo.getNombre());
		equipo_seleccionado.setNumserie(equipo.getNumserie());
		equipo_seleccionado.setVenta(equipo.getVenta());

		Equipos	equipo_actualizado = equipoServiceImpl.actualizarEquipo(equipo_seleccionado);

		return equipo_actualizado;
	}
	
	@DeleteMapping("/equipos/{id}")
	public void eliminarEquipo(@PathVariable(name = "id") Long id) {
		equipoServiceImpl.eliminarEquipo(id);
	}
}
