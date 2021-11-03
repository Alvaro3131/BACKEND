package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Socio;



public interface SocioService {
	List<Socio> readall();
	Socio create(Socio al);
	Socio read(int id);
	void delete(int id);
	Socio update(Socio al);
}
