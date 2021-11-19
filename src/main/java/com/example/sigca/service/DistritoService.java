package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Distrito;


public interface DistritoService {
	String insertarDistrito (Distrito d);
	List<Distrito> listarDistrito();
	Distrito buscarDistrito(int id_distrito);
	
	String eliminarDistrito(int id_distrito);
	String ActualizarDistrito(Distrito d);
}
