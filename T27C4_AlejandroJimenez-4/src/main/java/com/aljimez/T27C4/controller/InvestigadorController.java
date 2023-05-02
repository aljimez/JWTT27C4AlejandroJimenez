package com.aljimez.T27C4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aljimez.T27C4.dto.Investigador;
import com.aljimez.T27C4.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;

	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigador() {
		return investigadorServiceImpl.listarInvestigador();
	}

	@PostMapping("/investigadores")
	public Investigador guardarInvestigador(@RequestBody Investigador investigador) {
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}

	@GetMapping("/investigadores/{id}")
	public Investigador investigadorById(@PathVariable(name = "id") Long id) {
		Investigador investigador = investigadorServiceImpl.investigadorXID(id);
		return investigador;
	}

	@PutMapping("/investigadores/{id}")
	public Investigador actualizarInvestigador(@PathVariable(name = "id") Long id,
			@RequestBody Investigador investigador) {

		Investigador investigador_seleccionado = investigadorServiceImpl.investigadorXID(id);
		investigador_seleccionado.setId(id);
		investigador_seleccionado.setDni(investigador.getDni());
		investigador_seleccionado.setFacultad(investigador.getFacultad());
		investigador_seleccionado.setNomApels(investigador.getNomApels());
		investigador_seleccionado.setVenta(investigador.getVenta());

		Investigador investigador_actualizado = investigadorServiceImpl
				.actualizarInvestigador(investigador_seleccionado);
		return investigador_actualizado;
	}
	

	@DeleteMapping("/investigadores/{id}")
	public void eliminarInvestigador(@PathVariable(name = "id") Long id) {
		investigadorServiceImpl.eliminarInvestigador(id);
	}
}
