package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.Cientificos;

public interface ICientificoService {
	// Metodos del CRUD
		public List<Cientificos> listarCientifico();

		public Cientificos guardarCientifico(Cientificos cientifico);

		public Cientificos cientificoById(int id);

		public Cientificos actualizarCientifico(Cientificos cientifico);

		public void eliminarCientifico(int id);
}
