package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Seminario;

public interface SeminarioService {
	List<Seminario> listarSeminario();
	List<Seminario> listarSeminarioSocio(int id);
	String insertarSeminario(Seminario se);
	Seminario buscarSeminario(int id_seminario);
	String eliminarSeminario(int id_seminario);
	String actualizarSeminario(Seminario se);
}
