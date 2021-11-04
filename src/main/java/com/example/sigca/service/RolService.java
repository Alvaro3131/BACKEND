package com.example.sigca.service;

import java.util.List;

import com.example.sigca.entity.Rol;


public interface RolService {
	String insertarRol (Rol r);
	List<Rol> listarRol();
	Rol buscarRol(int id_rol);
	String eliminarRol(int id_rol);
	String ActualizarRol(Rol r);
}
