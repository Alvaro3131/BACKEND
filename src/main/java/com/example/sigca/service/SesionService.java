package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Sesion;

public interface SesionService {

	String insertarSesion (Sesion s);
	List<Sesion> ListarSesion();
	Sesion buscarSesion(int id_sesion);
	String eliminarSesion(int id_sesion);
	String actualizarSesion(Sesion s);
}
