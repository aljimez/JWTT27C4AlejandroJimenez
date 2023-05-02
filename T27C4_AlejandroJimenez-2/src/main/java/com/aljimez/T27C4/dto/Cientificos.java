package com.aljimez.T27C4.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cientificos")
public class Cientificos {

	

	@Id
	private String dni;

	@Column (name = "nombre_apellidos")
	private String nombreApellidos;

	@OneToMany
	@JoinColumn(name = "cientifico")
	private List<Asignadoa> asignadoA;

	
	public Cientificos() {
	}

	public Cientificos(String dni, String nombreApellidos) {
		this.dni = dni;
		this.nombreApellidos = nombreApellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado_a")
	public List<Asignadoa> getAsignadoA() {
		return asignadoA;
	}

	public void setAsignadoA(List<Asignadoa> asignadoA) {
		this.asignadoA = asignadoA;
	}
	
	
}
