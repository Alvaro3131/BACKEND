package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Modulo;

public interface ModuloService {
	String insertarModulo (Modulo m);

	List<Modulo> listarModulo();
	Modulo buscarModulo(int id_modulo);
	String eliminarModulo(int id_modulo);
	
	String actualizarModulo(Modulo m);
}
