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
@Table(name = "proyectos")
public class Proyectos {

	@Id
	private String id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "horas")
	private int horas;

	@OneToMany
	@JoinColumn(name = "proyecto")
	private List<Asignadoa> asignadoA;

	public Proyectos() {

	}

	public Proyectos(String id, String nombre, int horas) {
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
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
