package com.example.sigca.service;

import java.util.List;
import java.util.Map;

import com.example.sigca.entity.Privilegios;



public interface PrivilegiosService{
	String insertarPrivilegios (Privilegios p);
	List<Privilegios> ListarPrivilegios();
	List<Map<String,Object>> ListarPrivilegiosUsuario(int id);
	Privilegios buscarPrivilegios(int id_privilegios);
	String eliminarPrivilegios(int id_privilegios);
	String actualizarPrivilegios(Privilegios p);
}

