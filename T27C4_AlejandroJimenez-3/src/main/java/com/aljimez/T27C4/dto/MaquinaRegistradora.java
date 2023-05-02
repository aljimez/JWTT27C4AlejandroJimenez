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
	@Table(name = "maquinas")
	public class MaquinaRegistradora {
//Atributos de MaquinaRegistradora
		@Id
		@Column(name = "codigo")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "piso")
		private int piso;

		@OneToMany
		@JoinColumn(name = "venta")
		private List<Ventas> venta;

		// Getters y setters
		public MaquinaRegistradora() {

		}

		public Long getCodigo() {
			return id;
		}

		public void setCodigo(Long id) {
			this.id = id;
		}

		public int getPiso() {
			return piso;
		}

		public void setPiso(int piso) {
			this.piso = piso;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Ventas")
		public List<Ventas> getVenta() {
			return venta;
		}

		public void setVenta(List<Ventas> venta) {
			this.venta = venta;
		}
		
		
}
