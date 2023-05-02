package com.aljimez.T27C4.service;

import java.util.List;

import com.aljimez.T27C4.dto.Investigador;

public interface IInvestigadoresService {
	
	
	public List<Investigador> listarInvestigador();

	public Investigador guardarInvestigador(Investigador investigador);

	public Investigador investigadorXID(Long id);

	public Investigador actualizarInvestigador(Investigador investigador);

	public void eliminarInvestigador(Long id);
}
