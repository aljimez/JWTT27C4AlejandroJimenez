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

import com.aljimez.T27C4.dto.Producto;
import com.aljimez.T27C4.service.ProductoServiceImpl;


@RestController
@RequestMapping("/api")
public class ProductoController {

	

	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	

	@GetMapping("/productos")
	public List<Producto> listarProducto() {
		return productoServiceImpl.listarProducto();
	}

	@PostMapping("/productos")
	public Producto guardarProducto(@RequestBody Producto producto) {
		return productoServiceImpl.guardarProducto(producto);
	}

	@GetMapping("/productos/{id}")
	public Producto productoXID(@PathVariable(name = "id") Long id) {
		 Producto producto = productoServiceImpl.productoXID(id);
		return producto;
	}
	
	@PutMapping("/productos/{id}")
	public Producto actualizarProducto(@PathVariable(name = "id") Long id, @RequestBody Producto producto) {

		Producto producto_seleccionado = new Producto();
		Producto producto_actualizado = new Producto();
		producto_seleccionado = productoServiceImpl.productoXID(id);
		producto_seleccionado.setCodigo(id);
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		producto_seleccionado.setVenta(producto.getVenta());

		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);

		return producto_actualizado;
	}
	@DeleteMapping("/productos/{codigo}")
	public void eliminarProducto(@PathVariable(name = "id") Long id) {
		productoServiceImpl.eliminarProducto(id);
	}
}
