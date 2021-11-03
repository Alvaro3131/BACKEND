package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Seminario;

public interface SeminarioService {
	List<Seminario> listarSeminario();
	String insertarSeminario(Seminario se);
	Seminario buscarSeminario(int id_seminario);
	String eliminarSeminario(int id_seminario);
	String actualizarSeminario(Seminario se);
}
