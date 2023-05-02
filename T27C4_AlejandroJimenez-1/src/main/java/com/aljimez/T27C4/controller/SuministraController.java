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

import com.aljimez.T27C4.dto.Suministra;
import com.aljimez.T27C4.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;
	
	

	@GetMapping("/suministrar")
	public List<Suministra> listarSuministra(){
		return suministraServiceImpl.listarSuministra();
	}
	
	@PostMapping("/suministrar")
	public Suministra salvarSuministra(@RequestBody Suministra suministra) {
		
			return suministraServiceImpl.guardarSuministra(suministra);
	}
	

	@GetMapping("/suministrar/{id}")
	public Suministra suministrarXID(@PathVariable(name="id") Long id) {
		
		Suministra Suministra_xid= new Suministra();
		
		Suministra_xid=suministraServiceImpl.suministraXID(id);
		
		
		return Suministra_xid;
	}
	
	@PutMapping("/suministrar/{id}")
	public Suministra actualizarCurso(@PathVariable(name="id")Long id,@RequestBody Suministra suministra) {
		
		Suministra Suministrar_seleccionado= new Suministra();
		Suministra Suministrar_actualizado= new Suministra();
		
		Suministrar_seleccionado= suministraServiceImpl.suministraXID(id);
		
		Suministrar_seleccionado.setPrecio(suministra.getPrecio());
		
		Suministrar_actualizado = suministraServiceImpl.actualizarSuministra(Suministrar_seleccionado);
		
		
		return Suministrar_actualizado;
	}
	

	@DeleteMapping("/suministrar/{id}")
	public void eliminarSuministro(@PathVariable(name="id")Long id) {
		suministraServiceImpl.eliminarSuministra(id);
	}
	
}
