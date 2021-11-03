package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Persona;





public interface PersonaService {
	List<Persona> readall();
	Persona create(Persona al);
	Persona read(int id);
	void delete(int id);
	Persona update(Persona al);
}
