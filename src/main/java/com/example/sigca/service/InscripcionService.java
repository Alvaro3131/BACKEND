package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Inscripcion;


public interface InscripcionService {
	List<Inscripcion> readall();
	Inscripcion create(Inscripcion al);
	Inscripcion read(int id);
	void delete(int id);
	Inscripcion update(Inscripcion al);
}
