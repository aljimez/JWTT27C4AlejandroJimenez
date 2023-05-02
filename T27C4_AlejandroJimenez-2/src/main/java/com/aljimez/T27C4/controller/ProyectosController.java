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

import com.aljimez.T27C4.dto.Proyectos;
import com.aljimez.T27C4.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectosController {
	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;
	

	@GetMapping("/proyectos")
	public List<Proyectos> listarProyecto() {
		return proyectoServiceImpl.listarProyecto();
	}
	
	@PostMapping("/proyectos")
	public Proyectos guardarProyecto(@RequestBody Proyectos proyecto) {
		return proyectoServiceImpl.guardarProyectos(proyecto);
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyectos proyectosXID(@PathVariable(name = "id") Long id) {
		Proyectos proyectos = new Proyectos();
		proyectos = proyectoServiceImpl.proyectosXID(id);
		return proyectos;
	}
	
	@PutMapping("/proyectos/{id}")
	public Proyectos actualizarProyecto(@PathVariable(name = "id") Long id, @RequestBody Proyectos proyecto) {

		Proyectos proyecto_seleccionado = new Proyectos();
		Proyectos proyecto_actualizado = new Proyectos();
		
		proyecto_seleccionado = proyectoServiceImpl.proyectosXID(id);

		proyecto_seleccionado.setNombre(proyecto.getNombre());
		proyecto_seleccionado.setHoras(proyecto.getHoras());

		proyecto_actualizado = proyectoServiceImpl.actualizarProyectos(proyecto_seleccionado);
		return proyecto_actualizado;
	}

	@DeleteMapping("/proyectos/{id}")
	public void eliminarProyecto(@PathVariable(name = "id") Long id) {
		proyectoServiceImpl.eliminarProyectos(id);
	}
}
