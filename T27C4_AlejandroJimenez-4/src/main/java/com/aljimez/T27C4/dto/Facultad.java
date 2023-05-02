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
@Table(name = "facultad")
public class Facultad {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "equipo")
	private List<Equipos> equipo;

	@OneToMany
	@JoinColumn(name = "investigador")
	private List<Investigador> investigador;

	// CONSTRUCTORES
	public Facultad() {

	}
	public Facultad(String nombre) {
		this.nombre = nombre;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long id) {
		this.codigo = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipos")
	public List<Equipos> getEquipo() {
		return equipo;
	}
	public void setEquipo(List<Equipos> equipo) {
		this.equipo = equipo;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigadores")
	public List<Investigador> getInvestigador() {
		return investigador;
	}
	
	public void setInvestigador(List<Investigador> investigador) {
		this.investigador = investigador;
	}
	
	
}
