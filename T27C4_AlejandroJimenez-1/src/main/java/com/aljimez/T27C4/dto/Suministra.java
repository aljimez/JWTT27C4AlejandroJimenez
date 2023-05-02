package com.aljimez.T27C4.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "suministra")
public class Suministra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "precio")
	private int precio;

	@ManyToOne
	@JoinColumn(name = "pieza_id")
	private Piezas pieza;

	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedores proveedores;

	public Suministra() {
	}

	public Suministra(int precio, Piezas pieza, Proveedores proveedor) {

		this.precio = precio;
		this.pieza = pieza;
		this.proveedores = proveedor;

	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Piezas getPieza() {
		return pieza;
	}

	public void setPieza(Piezas pieza) {
		this.pieza = pieza;
	}

	public Proveedores getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}

	@Override
	public String toString() {
		return "Suministra [ precio=" + precio + ", piezas=" + pieza + ", proveedores=" + proveedores + "]";
	}

}
