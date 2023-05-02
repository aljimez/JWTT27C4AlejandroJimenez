package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.Piezas;

public interface IPiezasService {

	List<Piezas> listPiezas();

	Piezas guardarPiezas(Piezas piezas);

	Piezas actualizarPiezas(Piezas piezas);

	void eliminarPieza(Long id);


	Piezas piezasXID(Long id);

}
