package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Recurso;

public interface RecursoService {

	String insertarRecurso (Recurso rec);
	List<Recurso> listarRecurso();
	Recurso buscarRecurso(int id_recurso);
	String eliminarRecurso(int id_recurso);
	String actualizarRecurso(Recurso rec);
}
