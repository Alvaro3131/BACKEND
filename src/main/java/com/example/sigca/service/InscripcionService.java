package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Inscripcion;

public interface InscripcionService {

	String insertarInscripcion (Inscripcion ins);
	List<Inscripcion> listarInscripcion();
	Inscripcion buscarInscripcion(int id_inscripcion);
	String eliminarInscripcion(int id_inscripcion);
	String actualizarInscripcion(Inscripcion ins);
}
