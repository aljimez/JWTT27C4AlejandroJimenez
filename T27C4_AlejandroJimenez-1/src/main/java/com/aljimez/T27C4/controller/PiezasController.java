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

import com.aljimez.T27C4.dto.Piezas;
import com.aljimez.T27C4.service.PiezasServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezasController {

	
	@Autowired
	PiezasServiceImpl piezasServiceImpl;
	
	@GetMapping("/piezas")
	public List<Piezas> listarPiezas(){
		
		return piezasServiceImpl.listPiezas();
	}
	
	@PostMapping("/piezas")
	public Piezas salvarPiezas(@RequestBody Piezas piezas) {
		
	return 	piezasServiceImpl.guardarPiezas(piezas);
	}
	
	@GetMapping ("/piezas/{id}")
	public Piezas piezasXID(@PathVariable (name = "id")Long id) {
		
		
		 Piezas	piezas_xid = piezasServiceImpl.piezasXID(id);
		
		return piezas_xid;
		
	}
	
	@PutMapping("/piezas/{id}")
	public Piezas actualizarPiezas (@PathVariable(name = "id") Long id , @RequestBody Piezas piezas) {
		
		Piezas	Pieza_seleccionado = piezasServiceImpl.piezasXID(id);
		
		Pieza_seleccionado.setNombre(piezas.getNombre());
		
		Piezas	Pieza_actualizado = piezasServiceImpl.actualizarPiezas(Pieza_seleccionado);
		
		return Pieza_actualizado;
		
	}
	
	@DeleteMapping("/piezas/{id}")
	public void eliminarPiezas(@PathVariable(name ="id")Long id) {
		
		piezasServiceImpl.eliminarPieza(id);
	}
	
}
