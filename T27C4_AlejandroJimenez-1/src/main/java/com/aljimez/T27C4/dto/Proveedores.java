package com.aljimez.T27C4.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedores {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "suministra")
	private List<Suministra> suministra;

	public Proveedores() {}

	public Proveedores( String nombre) {
		this.nombre = nombre;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
	public List<Suministra> getSuministra() {
		return suministra;
	}
	
	@Override
	public String toString() {
		return "Proveedores [id=" + id + ", nombre=" + nombre + ", suministra=" + suministra + "]";
	}

}
