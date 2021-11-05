package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Alternativa;

public interface AlternativaService {

	String insertarAlternativa (Alternativa alt);
	List<Alternativa> listarAlternativa();
	Alternativa buscarAlternativa(int id_alternativa);
	String eliminarAlternativa(int id_alternativa);
	String actualizarAlternativa(Alternativa alt);
}
