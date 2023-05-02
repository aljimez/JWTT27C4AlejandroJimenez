package com.aljimez.T27C4.dto;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "reserva")
public class Reserva {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "comienzo")
	private Date comienzo;

	@Column(name = "fin")
	private Date fin;

	@ManyToOne
	@JoinColumn(name = "equipos")
	private Equipos equipo;

	@ManyToOne
	@JoinColumn(name = "investigador")
	private Investigador investigador;

	// CONTRUCTORES
	public Reserva() {

	}

	public Reserva(Date comienzo, Date fin, Equipos equipo, Investigador investigador) {
		this.comienzo = comienzo;
		this.fin = fin;
		this.equipo = equipo;
		this.investigador = investigador;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getComienzo() {
		return comienzo;
	}

	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Equipos getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}
	
	

}
