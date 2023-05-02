package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.Reserva;

public interface IReservaService {

	
	public List<Reserva> listarReserva();

	public Reserva guardarReserva(Reserva reserva);

	public Reserva reservaXID(Long id);

	public Reserva actualizarReserva(Reserva reserva);

	public void eliminarReserva(Long id);
}
