package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Sesion;

public interface SesionService {

	List<Sesion> readAll();
	Sesion create (Sesion al);
	Sesion read(int id);
	void delete(int id);
	Sesion update(Sesion al);
}
