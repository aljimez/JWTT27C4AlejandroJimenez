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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipos {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "numserie")
private String numserie;
@Column(name = "nombre")
private String nombre;
@OneToMany
@JoinColumn(name = "venta")
private List<Reserva> venta;

@ManyToOne
@JoinColumn(name = "facultad")
private Facultad facultad;

// CONSTRUCTORES
public Equipos() {

}


public Equipos(String numserie, String nombre, Facultad facultad) {
	this.numserie = numserie;
	this.nombre = nombre;
	this.facultad = facultad;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getNumserie() {
	return numserie;
}


public void setNumserie(String numserie) {
	this.numserie = numserie;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}

@JsonIgnore
@OneToMany(fetch = FetchType.LAZY, mappedBy = "Ventas")
public List<Reserva> getVenta() {
	return venta;
}

public void setVenta(List<Reserva> venta) {
	this.venta = venta;
}


public Facultad getFacultad() {
	return facultad;
}


public void setFacultad(Facultad facultad) {
	this.facultad = facultad;
}

}


