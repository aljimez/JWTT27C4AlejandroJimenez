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

import com.aljimez.T27C4.dto.Cajero;
import com.aljimez.T27C4.service.CajeroServiceImpl;


@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServiceImpl cajeroServiceImpl;
	
	
	@GetMapping("/cajeros")
	public List<Cajero> listarCajero() {
		return cajeroServiceImpl.listarCajero();
	}
	

	@PostMapping("/cajeros")
	public Cajero guardarCajero(@RequestBody Cajero cajero) {
		return cajeroServiceImpl.guardarCajero(cajero);
	}
	
	@GetMapping("/cajeros/{id}")
	public Cajero cajeroById(@PathVariable(name = "codigo") Long id) {
		 Cajero	cajero = cajeroServiceImpl.cajeroXID(id);
		return cajero;
	}
	@PutMapping("/cajeros/{codigo}")
	public Cajero actualizarCajero(@PathVariable(name = "codigo") Long id, @RequestBody Cajero cajero) {

		
		Cajero cajero_seleccionado = cajeroServiceImpl.cajeroXID(id);
		cajero_seleccionado.setCodigo(id);
		cajero_seleccionado.setNomApels(cajero.getNomApels());
		cajero_seleccionado.setVenta(cajero.getVenta());

		Cajero cajero_actualizado = cajeroServiceImpl.actualizarCajero(cajero_seleccionado);

		return cajero_actualizado;
	}
	
	@DeleteMapping("/cajeros/{codigo}")
	public void eliminarCajero(@PathVariable(name = "codigo") Long id) {
		cajeroServiceImpl.eliminarCajero(id);
	}

}
