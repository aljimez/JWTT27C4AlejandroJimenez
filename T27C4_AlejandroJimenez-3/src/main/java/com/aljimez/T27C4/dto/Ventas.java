package com.aljimez.T27C4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta")
public class Ventas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "cajero")
	private Cajero cajero;

	@ManyToOne
	@JoinColumn(name = "maquina")
	private MaquinaRegistradora maquina;

	@ManyToOne
	@JoinColumn(name = "producto")
	private Producto producto;

	// CONTRUCTORES
	public Ventas() {

	}

	public Ventas(int precio, Cajero cajero, MaquinaRegistradora maquina, Producto producto) {
		this.producto = producto;
		this.cajero = cajero;
		this.maquina = maquina;
	}
	



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public MaquinaRegistradora getMaquina() {
		return maquina;
	}

	public void setMaquina(MaquinaRegistradora maquina) {
		this.maquina = maquina;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
