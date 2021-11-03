package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Asesor;


public interface AsesorService {
	List<Asesor> readall();
	Asesor create(Asesor al);
	Asesor read(int id);
	void delete(int id);
	Asesor update(Asesor al);
}
