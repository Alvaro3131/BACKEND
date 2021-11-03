package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Pregunta;


public interface PreguntaService {

	String insertarPregunta (Pregunta preg);
	List<Pregunta> listarPregunta();
	Pregunta buscarPregunta(int id_pregunta);
	String eliminarPregunta(int id_pregunta);
	String actualizarPregunta(Pregunta preg);
}
