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

import com.aljimez.T27C4.dto.Ventas;
import com.aljimez.T27C4.service.VentasServiceImpl;

@RestController
@RequestMapping("/api")
public class VentasController {
	

	@Autowired
	VentasServiceImpl ventaServiceImpl;
	
	
	@GetMapping("/ventas")
	public List<Ventas> listarVenta() {
		return ventaServiceImpl.listarVenta();
	}
	
	@PostMapping("/ventas")
	public Ventas guardarVenta(@RequestBody Ventas venta) {
		return ventaServiceImpl.guardarVenta(venta);
	}
	
	@GetMapping("/ventas/{id}")
	public Ventas ventaById(@PathVariable(name = "id") Long id) {
		Ventas	venta = ventaServiceImpl.ventaXID(id);
		return venta;
	}
	
	@PutMapping("/ventas/{id}")
	public Ventas actualizarVenta(@PathVariable(name = "id") Long id, @RequestBody Ventas venta) {

		
		 Ventas venta_seleccionado = ventaServiceImpl.ventaXID(id);
		venta_seleccionado.setId(id);
		venta_seleccionado.setMaquina(venta.getMaquina());
		venta_seleccionado.setCajero(venta.getCajero());
		venta_seleccionado.setProducto(venta.getProducto());

		Ventas	venta_actualizado = ventaServiceImpl.actualizarVenta(venta_seleccionado);
		return venta_actualizado;
	}
	@DeleteMapping("/ventas/{id}")
	public void eliminarVenta(@PathVariable(name = "id") Long id) {
		ventaServiceImpl.eliminarVenta(id);
	}
	
}
